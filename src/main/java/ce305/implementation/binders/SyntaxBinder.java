package ce305.implementation.binders;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ce305.abstraction.DataType;
import ce305.abstraction.INode;
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
import ce305.abstraction.utils.KeyWords;
import ce305.abstraction.utils.ScopeType;
import ce305.abstraction.utils.Symbol;
import ce305.implementation.errors.DuplicateDefinitionException;
import ce305.implementation.errors.IncorrectDataType;
import ce305.implementation.errors.MissingParametersException;
import ce305.implementation.errors.UndefinedFunctionException;
import ce305.implementation.errors.UndefinedFunctionReturnStatementException;
import ce305.implementation.errors.UndefinedVariableException;
import ce305.implementation.visitors.DataTypeChecker;
import ce305.utils.FunctionNameDefinition;
import ce305.utils.SymbolTable;

public class SyntaxBinder extends Binder<INode> {
    private Stack<SymbolTable> _tableStack = new Stack<>();

    private SymbolTable symbolTable() {
        return _tableStack.peek();
    }


    @Override
    public INode bind(ProgramNode node, BinderType type) {
        _tableStack.add(new SymbolTable(ScopeType.Program));
        return node;
    }

    @Override
    public INode bind(BinaryExpressionNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            return new BinaryExpressionNode(this.bind(node.left, type), this.bind(node.right, type), node.operation);
        }

        return node;
    }

    @Override
    public INode bind(AssignmentNode node, BinderType type) {

        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            INode left = this.bind(node.left, type);
            INode right = this.bind(node.right, type);
    
            // Need to run some extra checks if the left node is an instance of a variable.
            if (left instanceof VariableNode) {
                // Attempt to retrieve the variable out of the symbol table
                Symbol temp = this.symbolTable().get(((VariableNode) left).value);
                if (temp != null) {
                    // Check that the correct data type is being assigned to this variable
                    if (temp.dataType == DataType.BOOL) {
                        if (!(right instanceof BooleanExpressionNode) && !new DataTypeChecker(temp.dataType, this.symbolTable()).visit(right)) {
                            throw new IncorrectDataType(String.format("\"%s\" was expecting data type of %s", temp.name, temp.dataType));
                        }
                    }                    
                    else if (!new DataTypeChecker(temp.dataType, this.symbolTable()).visit(right))
                        throw new IncorrectDataType(
                                String.format("\"%s\" was expecting data type of %s", temp.name, temp.dataType));
                    
                } else {
                    throw new UndefinedVariableException(String.format(
                            "Variable \"%s\" has not been defined in the current scope", ((VariableNode) left).value));
                }
            }
    
            return new AssignmentNode(left, right, node.operation);
        }

        return node;
    }

    @Override
    public INode bind(NegateNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            return new NegateNode(this.bind(node.innerNode, type));
        }

        return node;
    }

    @Override
    public INode bind(FunctionNode node, BinderType type) {        
        if (type == BinderType.DeclarationOnly || type == BinderType.All) {
            // Add a new symbol to the table that references the function node
            this.symbolTable().add(new Symbol(new FunctionNameDefinition(node).toString(), node.dataType, node.params));
        }

        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            ArrayList<INode> body = new ArrayList<>();
            ArrayList<FunctionParamNode> params = new ArrayList<>();

            // Add a new top level scope.
            _tableStack.add(new SymbolTable(this.symbolTable(), ScopeType.Function));

            for (FunctionParamNode param : node.params) {
                params.add((FunctionParamNode) this.bind(param, type));
            }
            
            if (node.dataType != DataType.VOID && !node.body.stream().anyMatch(c -> c instanceof FunctionReturnStatementNode)) {
                throw new UndefinedFunctionReturnStatementException(String.format("function: \"%s\" is a non void type and must return a value", node.name));
            }

            for (INode child : node.body) {
                this.bind(child, BinderType.DeclarationOnly);
            }

            for (INode child : node.body) {
                body.add(this.bind(child, BinderType.SyntaxOnly));
            }
    
            _tableStack.pop();

            return new FunctionNode(node.dataType, node.name, body, params);
        }

        return node;
    }

    @Override
    public INode bind(ValueNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            // If the value node is a reference to a symbol in the symbol table then just return a new variable node.
            if (this.symbolTable().contains(node.value.toString())) {
                return new VariableNode(node.value.toString());
            }
            
            Pattern p = Pattern.compile("[A-Za-z]+");
            Matcher m = p.matcher(node.value.toString());

            Pattern boolP = Pattern.compile(String.format("(%s|%s)", KeyWords.TRUE, KeyWords.FALSE));
            Matcher boolM = p.matcher(node.value.toString());

            // Check whether the value is a string built up of aplha chars, and throw an error as the variable must have not been defined.
            if (m.find() && !boolM.find()) {
                throw new UndefinedVariableException(
                        String.format("Variable \"%s\" has not been defined in the current scope", node.value));
            }
        }

        return node;
    }

    @Override
    public INode bind(VariableNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) { 
            if (!this.symbolTable().contains(node.value.toString())) {
                throw new UndefinedVariableException(String.format("Variable \"%s\" has not been defined in the current scope", node.value));
            }                
        }

        return node;
    }

    @Override
    public INode bind(DeclarationNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            // Check to see variable already exists in the symbol table and throw if it does.
            if (this.symbolTable().containsDeclaration(node.name))
            throw new DuplicateDefinitionException(
                    String.format("\"%s\" already exists in the current scope", node.name));

            this.symbolTable().add(new Symbol(node.name, node.dataType));
        }

        return node;
    }

    @Override
    public INode bind(IfStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            // Add a new nested scope.
            _tableStack.add(new SymbolTable(this.symbolTable(), ScopeType.If));
            ArrayList<INode> body = new ArrayList<>();
            INode expression = this.bind(node.expression, BinderType.SyntaxOnly);

            if (!(expression instanceof BooleanExpressionNode) && !new DataTypeChecker(DataType.BOOL, this.symbolTable()).visit(expression)) {
                throw new IncorrectDataType("If statement expressions must be of data type BOOL");
            } 

            for (INode child : node.body) {
                this.bind(child, BinderType.DeclarationOnly);
            }

            for (INode child : node.body) {
                body.add(this.bind(child, BinderType.SyntaxOnly));
            }

            _tableStack.pop();

            return new IfStatementNode(body, expression, node.child != null ? this.bind(node.child, type) : node.child);
        }

        return node;
    }

    @Override
    public INode bind(ElseStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            // Add a new nested scope.
            _tableStack.add(new SymbolTable(this.symbolTable(), ScopeType.If));
            ArrayList<INode> body = new ArrayList<>();

            for (INode child : node.body) {
                this.bind(child, BinderType.DeclarationOnly);
            }

            for (INode child : node.body) {
                body.add(this.bind(child, BinderType.SyntaxOnly));
            }

            _tableStack.pop();
            return new ElseStatementNode(body);
        }

        return node;
    }

    @Override
    public INode bind(ElseIfStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
           // Add a new nested scope.
            _tableStack.add(new SymbolTable(this.symbolTable(), ScopeType.If));

            ArrayList<INode> body = new ArrayList<>();
            INode expression = this.bind(node.expression, BinderType.SyntaxOnly);

            if (!(expression instanceof BooleanExpressionNode) && !new DataTypeChecker(DataType.BOOL, this.symbolTable()).visit(expression)) {
                throw new IncorrectDataType("If statement expressions must be of data type BOOL");
            } 

            for (INode child : node.body) {
                this.bind(child, BinderType.DeclarationOnly);
            }

            for (INode child : node.body) {
                body.add(this.bind(child, BinderType.SyntaxOnly));
            }
            _tableStack.pop();
            return new ElseIfStatementNode(body, node.expression, node.child != null ? this.bind(node.child, type) : node.child);
        }

        return node;
    }

    @Override
    public INode bind(BooleanExpressionNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            return new BooleanExpressionNode(this.bind(node.left, type), this.bind(node.right, type), node.operation);
        }
 
        return node;
    }

    @Override
    public INode bind(WhileStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            // Add a new nested scope.
            _tableStack.add(new SymbolTable(this.symbolTable(), ScopeType.While));
            ArrayList<INode> body = new ArrayList<>();

            for (INode child : node.body) {
                this.bind(child, BinderType.DeclarationOnly);
            }

            for (INode child : node.body) {
                body.add(this.bind(child, BinderType.SyntaxOnly));
            }

            _tableStack.pop();
            return new WhileStatementNode(body, node.expression);
        }
 
        return node;
    }

    @Override
    public INode bind(FunctionParamNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            this.symbolTable().add(new Symbol(node.name, node.dataType));
        }
        
        return node;
    }

    @Override
    public INode bind(FunctionReturnStatementNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            INode expression = this.bind(node.expression, type);

            // Check to see if the correct data type is returned for the function.
            if (!new DataTypeChecker(node.parent.dataType, this.symbolTable()).visit(expression)) {
                throw new IncorrectDataType(String.format("Function \"%s\" was expecting a return of data type %s", node.parent.name, node.parent.dataType));
            }                

            return new FunctionReturnStatementNode(expression, node.parent);
        }
        
        return node;
    }

    @Override
    public INode bind(FunctionCallNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            
            ArrayList<FunctionCallParamNode> params = new ArrayList<>();
            for (FunctionCallParamNode param : node.params) {
                params.add((FunctionCallParamNode)this.bind(param, type));
            }

            FunctionCallNode newNode = new FunctionCallNode(node.name, params);


            FunctionNameDefinition functionBestMatch = new FunctionNameDefinition(newNode, this.symbolTable());
            Symbol symbol = this.symbolTable().get(functionBestMatch.toString());

            if (symbol == null) {
                throw new UndefinedFunctionException(String.format("Function \"%s(%s)\" has not been defined in the current scope", node.name, functionBestMatch.getDataTypeParams()));
            }

            

            return newNode;
        }

        return node;
    }

    @Override
    public INode bind(FunctionCallParamNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            return new FunctionCallParamNode(this.bind(node.expression, type));
        }
        
        return node;
    }

    @Override
    public INode bind(ParenthesesExpressionNode node, BinderType type) {
        if (type == BinderType.SyntaxOnly || type == BinderType.All) {
            return new ParenthesesExpressionNode(this.bind(node.innerExpression, type));
        }
        
        return node;
    }

}