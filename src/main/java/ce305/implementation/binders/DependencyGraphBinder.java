package ce305.implementation.binders;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ce305.abstraction.INode;
import ce305.abstraction.dependency.DependencyGraph;
import ce305.abstraction.expressions.AssignmentNode;
import ce305.abstraction.expressions.BinaryExpressionNode;
import ce305.abstraction.expressions.BooleanExpressionNode;
import ce305.abstraction.expressions.DeclarationNode;
import ce305.abstraction.expressions.FunctionCallNode;
import ce305.abstraction.expressions.NegateNode;
import ce305.abstraction.expressions.ParenthesesExpressionNode;
import ce305.abstraction.expressions.ProgramNode;
import ce305.abstraction.expressions.ValueNode;
import ce305.abstraction.expressions.VariableNode;
import ce305.abstraction.functions.FunctionCallParamNode;
import ce305.abstraction.functions.FunctionNode;
import ce305.abstraction.functions.FunctionParamNode;
import ce305.abstraction.statements.ElseIfStatementNode;
import ce305.abstraction.statements.ElseStatementNode;
import ce305.abstraction.statements.FunctionReturnStatementNode;
import ce305.abstraction.statements.IfStatementNode;
import ce305.abstraction.statements.WhileStatementNode;
import ce305.implementation.visitors.ASTDependencyRetriever;

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
        for (INode child : node.children) {
            this.bind(child, type);

            if (type == BinderType.SyntaxOnly || type == BinderType.All) {
                _dependencyGraph.addDependancy(node, child);
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

            // for (INode dependency : this.getDependencies(node.left)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }

            // for (INode dependency : this.getDependencies(node.right)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(AssignmentNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            // this.bind(node.left, type);
            // this.bind(node.right, type);
            // for (INode dependency : this.getDependencies(node.left)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }
    
            // for (INode dependency : this.getDependencies(node.right)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }

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

        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            for (INode child: node.body) {
                this.bind(child, type);
            }
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

            // for (INode dependency : this.getDependencies(node.expression)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }

            for (INode child: node.body) {
                this.bind(child, type);
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

            for (INode child: node.body) {
                this.bind(child, type);
            }
        }

        return _dependencyGraph;
    }

    @Override
    public DependencyGraph bind(ElseIfStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            // for (INode dependency : this.getDependencies(node.expression)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }

            this.bind(node.expression, type);

            _dependencyGraph.addDependancy(node, node.expression);

            for (INode child: node.body) {
                this.bind(child, type);
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
            // for (INode dependency : this.getDependencies(node.left)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }
    
            // for (INode dependency : this.getDependencies(node.right)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }

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
            // for (INode dependency : this.getDependencies(node.expression)) {
            //     _dependencyGraph.addDependancy(node, dependency);
            // }

            this.bind(node.expression, type);

            _dependencyGraph.addDependancy(node, node.expression);

            for (INode child: node.body) {
                this.bind(child, type);
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