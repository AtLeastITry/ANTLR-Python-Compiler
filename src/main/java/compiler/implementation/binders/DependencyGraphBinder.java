package compiler.implementation.binders;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import compiler.abstraction.INode;
import compiler.abstraction.dependency.DependencyGraph;
import compiler.abstraction.expressions.AssignmentNode;
import compiler.abstraction.expressions.BinaryExpressionNode;
import compiler.abstraction.expressions.BooleanExpressionNode;
import compiler.abstraction.expressions.DeclarationNode;
import compiler.abstraction.expressions.FunctionCallNode;
import compiler.abstraction.expressions.NegateNode;
import compiler.abstraction.expressions.ParenthesesExpressionNode;
import compiler.abstraction.expressions.ProgramNode;
import compiler.abstraction.expressions.ValueNode;
import compiler.abstraction.expressions.VariableNode;
import compiler.abstraction.functions.FunctionCallParamNode;
import compiler.abstraction.functions.FunctionNode;
import compiler.abstraction.functions.FunctionParamNode;
import compiler.abstraction.statements.ElseIfStatementNode;
import compiler.abstraction.statements.ElseStatementNode;
import compiler.abstraction.statements.FunctionReturnStatementNode;
import compiler.abstraction.statements.IfStatementNode;
import compiler.abstraction.statements.WhileStatementNode;
import compiler.implementation.visitors.ASTDependencyRetriever;

public class DependencyGraphBinder extends Binder<DependencyGraph> {
    private final DependencyGraph _dependencyGraph;
    private ArrayList<FunctionNode> _functions;
    private ArrayList<DeclarationNode> _variables;

    public DependencyGraphBinder() {
        _dependencyGraph = new DependencyGraph();
        _functions = new ArrayList<>();
        _variables = new ArrayList<>();
    }

    private ArrayList<INode> getDependencies(INode tree) {
        return new ASTDependencyRetriever(_functions, _variables).visit(tree);
    }

    @Override
    public DependencyGraph bind(ProgramNode node, BinderType type) {
        int childrenLength = node.children.size();
        for (int i = 0; i < childrenLength; i++) {
            INode child = node.children.get(i);

            this.bind(child, type);

            if (type == BinderType.SyntaxOnly || type == BinderType.All) {
                _dependencyGraph.addDependancy(node, child);

                if ((i + 1) < childrenLength) {
                    INode nextChild = node.children.get(i + 1);

                    if (child instanceof FunctionNode || nextChild instanceof FunctionNode) {
                        continue;
                    }

                    _dependencyGraph.addDependancy(nextChild, child);
                }
            }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(BinaryExpressionNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.left, type);
            this.bind(node.right, type);

            _dependencyGraph.addDependancy(node, node.left);
            _dependencyGraph.addDependancy(node, node.right);
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(AssignmentNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.left, type);
            this.bind(node.right, type);

            _dependencyGraph.addDependancy(node, node.left);
            _dependencyGraph.addDependancy(node, node.right);
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(NegateNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.innerNode, type);
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(FunctionNode node, BinderType type) {
        if (type == BinderType.DeclarationOnly || type == BinderType.All) {
            _functions.add(node);
        }        

        for (INode child: node.body) {
            this.bind(child, type);
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(ValueNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            for (INode dependency : this.getDependencies(node)) {
                _dependencyGraph.addDependancy(node, dependency);
            }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(VariableNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            for (INode dependency : this.getDependencies(node)) {
                _dependencyGraph.addDependancy(node, dependency);
            }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(DeclarationNode node, BinderType type) {
        if (type == BinderType.DeclarationOnly || type == BinderType.All) {
            _variables.add(node);
        }        

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(IfStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.expression, type);

            _dependencyGraph.addDependancy(node, node.expression);
        }
        
        int childrenLength = node.body.size();
        for (int i = 0; i < childrenLength; i++) {
            INode child = node.body.get(i);

            this.bind(child, type);

            if (type == BinderType.SyntaxOnly || type == BinderType.All) {
                _dependencyGraph.addDependancy(node, child);

                if ((i + 1) < childrenLength) {
                    INode nextChild = node.body.get(i + 1);

                    if (child instanceof FunctionNode || nextChild instanceof FunctionNode) {
                        continue;
                    }

                    _dependencyGraph.addDependancy(nextChild, child);
                }
            }
        }
        
        if (node.child != null) {
            this.bind(node.child, type);
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(ElseStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {

            int childrenLength = node.body.size();
            for (int i = 0; i < childrenLength; i++) {
                INode child = node.body.get(i);
    
                this.bind(child, type);
    
                if (type == BinderType.SyntaxOnly || type == BinderType.All) {
                    _dependencyGraph.addDependancy(node, child);
    
                    if ((i + 1) < childrenLength) {
                        INode nextChild = node.body.get(i + 1);
    
                        if (child instanceof FunctionNode || nextChild instanceof FunctionNode) {
                            continue;
                        }
    
                        _dependencyGraph.addDependancy(nextChild, child);
                    }
                }
            }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(ElseIfStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.expression, type);

            _dependencyGraph.addDependancy(node, node.expression);
        }

        int childrenLength = node.body.size();
        for (int i = 0; i < childrenLength; i++) {
            INode child = node.body.get(i);

            this.bind(child, type);

            if (type == BinderType.SyntaxOnly || type == BinderType.All) {
                _dependencyGraph.addDependancy(node, child);

                if ((i + 1) < childrenLength) {
                    INode nextChild = node.body.get(i + 1);

                    if (child instanceof FunctionNode || nextChild instanceof FunctionNode) {
                        continue;
                    }

                    _dependencyGraph.addDependancy(nextChild, child);
                }
            }
        }
        
        if (node.child != null) {
            this.bind(node.child, type);
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(BooleanExpressionNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.left, type);
            this.bind(node.right, type);

            _dependencyGraph.addDependancy(node, node.left);
            _dependencyGraph.addDependancy(node, node.right);
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(WhileStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.expression, type);

            _dependencyGraph.addDependancy(node, node.expression);
        }

        int childrenLength = node.body.size();
        for (int i = 0; i < childrenLength; i++) {
            INode child = node.body.get(i);

            this.bind(child, type);

            if (type == BinderType.SyntaxOnly || type == BinderType.All) {
                _dependencyGraph.addDependancy(node, child);

                if ((i + 1) < childrenLength) {
                    INode nextChild = node.body.get(i + 1);

                    if (child instanceof FunctionNode || nextChild instanceof FunctionNode) {
                        continue;
                    }

                    _dependencyGraph.addDependancy(nextChild, child);
                }
            }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(FunctionParamNode node, BinderType type) {
        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(FunctionReturnStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.expression, type);

            _dependencyGraph.addDependancy(node, node.expression);
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(FunctionCallNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            for (INode dependency : this.getDependencies(node)) {
                _dependencyGraph.addDependancy(node, dependency);
            }

            for (INode param : node.params) {
                this.bind(param, type);
            }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(FunctionCallParamNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            for (INode dependency : this.getDependencies(node)) {
                _dependencyGraph.addDependancy(node, dependency);
            }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(ParenthesesExpressionNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.bind(node.innerExpression, type);

            _dependencyGraph.addDependancy(node, node.innerExpression);
        }

        return _dependencyGraph;
    }
}