package ce305.implementation.visitors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ce305.abstraction.*;
import ce305.abstraction.expressions.*;
import ce305.abstraction.functions.*;
import ce305.abstraction.statements.*;
import ce305.abstraction.utils.KeyWords;
import ce305.abstraction.utils.Symbol;
import ce305.utils.SymbolTable;

public class DataTypeChecker extends ASTVisitor<Boolean>
{
    private final DataType _type;
    private final SymbolTable _table;

    public DataTypeChecker(DataType type, SymbolTable table) {
        _type = type;
        _table = table;
    }

    @Override
    public Boolean visit(ProgramNode node) {
        return node.children.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(BinaryExpressionNode node) {
        return this.visit(node.left) && this.visit(node.right);
    }

    @Override
    public Boolean visit(AssignmentNode node) {
        return this.visit(node.left) && this.visit(node.right);
    }

    @Override
    public Boolean visit(NegateNode node) {
        return this.visit(node.innerNode);
    }

    @Override
    public Boolean visit(FunctionNode node) {
        return node.dataType == _type && node.body.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(ValueNode node) {
        try {
            switch(_type) {
                case INTEGER:
                    Integer.parseInt(node.value.toString());
                    break;
                case FLOAT:
                    Float.parseFloat(node.value.toString());
                    break;
                case BOOL:
                    Pattern p = Pattern.compile(String.format("(%s|%s)", KeyWords.TRUE, KeyWords.FALSE));
                    Matcher m = p.matcher(node.value.toString());
                    if (m.find()) {
                        return true;
                    }
                    else {
                        return false;
                    }
            }
        }
        catch(Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean visit(VariableNode node) {
        Symbol symbol = _table.get(node.value);

        return symbol.dataType == _type;
    }

    @Override
    public Boolean visit(DeclarationNode node) {
        return true;
    }

    @Override
    public Boolean visit(IfStatementNode node) {
        return node.body.stream().allMatch(c -> this.visit(c)) && this.visit(node.child);
    }

    @Override
    public Boolean visit(ElseStatementNode node) {
        return node.body.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(ElseIfStatementNode node) {
        return node.body.stream().allMatch(c -> this.visit(c)) && this.visit(node.child);
    }

    @Override
    public Boolean visit(BooleanExpressionNode node) {
        if (_type == DataType.BOOL) {
            return true;
        }
        
        return this.visit(node.left) && this.visit(node.right);
    }

    @Override
    public Boolean visit(WhileStatementNode node) {
        return node.body.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(FunctionParamNode node) {
        return true;
    }

    @Override
    public Boolean visit(FunctionReturnStatementNode node) {
        return this.visit(node.expression);
    }

    @Override
    public Boolean visit(FunctionCallNode node) {
        Symbol symbol = _table.get(node.name);
        if (symbol != null) {
            return symbol.dataType == _type;
        }
        
        return false;
    }

    @Override
    public Boolean visit(FunctionCallParamNode node) {
        return this.visit(node.expression);
    }

    @Override
    public Boolean visit(ParenthesesExpressionNode node) {
        return this.visit(node.innerExpression);
    }
}