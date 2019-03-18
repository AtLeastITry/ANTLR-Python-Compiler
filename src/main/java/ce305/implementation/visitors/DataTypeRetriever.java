package ce305.implementation.visitors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ce305.abstraction.DataType;
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
import ce305.abstraction.utils.Symbol;
import ce305.utils.FunctionNameDefinition;
import ce305.utils.SymbolTable;

public class DataTypeRetriever extends ASTVisitor<DataType> {

    private final SymbolTable _table;

    public DataTypeRetriever(SymbolTable table) {
        _table = table;
    }

    private boolean tryParseInt(String value) {  
        try {  
            Integer.parseInt(value);  
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
    }

    private boolean tryParseFloat(String value) {  
        if (!value.contains(".")) {
            return false;
        }

        try {  
            Float.parseFloat(value);
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
    }

    private boolean tryParseBool(String value) {  
        Pattern p = Pattern.compile(String.format("(%s|%s)", KeyWords.TRUE, KeyWords.FALSE));
        Matcher m = p.matcher(value);

        return m.find();
    }

    @Override
    public DataType visit(ProgramNode node) {
        return null;
    }

    @Override
    public DataType visit(BinaryExpressionNode node) {
        DataType left = this.visit(node.left);
        DataType right = this.visit(node.right);

        if (left == DataType.FLOAT || right ==  DataType.FLOAT) {
            return DataType.FLOAT;
        }

        return DataType.INTEGER;
    }

    @Override
    public DataType visit(AssignmentNode node) {
        return null;
    }

    @Override
    public DataType visit(NegateNode node) {
        return this.visit(node.innerNode);
    }

    @Override
    public DataType visit(FunctionNode node) {
        return node.dataType;
    }

    @Override
    public DataType visit(ValueNode node) {
        String value = node.value.toString();

        if (this.tryParseBool(value)) {
            return DataType.BOOL;
        }

        if (this.tryParseFloat(value)) {
            return DataType.FLOAT;
        }

        if (this.tryParseInt(value)) {
            return DataType.INTEGER;
        }

        return null;
    }

    @Override
    public DataType visit(VariableNode node) {
        Symbol temp = _table.get(node.value);
        if (temp != null) {
            return temp.dataType;
        }
        
        return null;
    }

    @Override
    public DataType visit(DeclarationNode node) {
        return node.dataType;
    }

    @Override
    public DataType visit(IfStatementNode node) {
        return null;
    }

    @Override
    public DataType visit(ElseStatementNode node) {
        return null;
    }

    @Override
    public DataType visit(ElseIfStatementNode node) {
        return null;
    }

    @Override
    public DataType visit(BooleanExpressionNode node) {
        return null;
    }

    @Override
    public DataType visit(WhileStatementNode node) {
        return null;
    }

    @Override
    public DataType visit(FunctionParamNode node) {
        return node.dataType;
    }

    @Override
    public DataType visit(FunctionReturnStatementNode node) {
        return this.visit(node.expression);
    }

    @Override
    public DataType visit(FunctionCallNode node) {
        Symbol temp = _table.get(new FunctionNameDefinition(node, _table).toString());
        if (temp != null) {
            return temp.dataType;
        }
        
        return null;
    }

    @Override
    public DataType visit(FunctionCallParamNode node) {
        return this.visit(node.expression);
    }

    @Override
    public DataType visit(ParenthesesExpressionNode node) {
        return this.visit(node.innerExpression);
    }

}