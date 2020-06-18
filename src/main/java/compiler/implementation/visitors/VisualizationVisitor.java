package compiler.implementation.visitors;

import compiler.abstraction.INode;
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
import compiler.utils.ConsoleColor;

public class VisualizationVisitor extends ASTVisitor<String> {
    private static final String IndentString = "|   ";
    private Integer _depth;

    public VisualizationVisitor() {
        _depth = 0;
    }

    private void addLine(StringBuilder output) {
        output.append("\r\n");
    }

    public String buildIndentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(ConsoleColor.BLUE_BOLD_BRIGHT);
        sb.append("       ");

        for (int i = 0; i < _depth; i++) {
            sb.append(IndentString);
        }

        return sb.toString();
    }

    @Override
    public String visit(ProgramNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        for (INode child : node.children) {
            sb.append(this.visit(child));
        }

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(BinaryExpressionNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        sb.append(this.visit(node.left));
        sb.append(this.visit(node.right));

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(AssignmentNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        sb.append(this.visit(node.left));
        sb.append(this.visit(node.right));

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(NegateNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        sb.append(this.visit(node.innerNode));

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(FunctionNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        for (INode param : node.params) {
            sb.append(this.visit(param));
        }

        for (INode child : node.body) {
            sb.append(this.visit(child));
        }

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(ValueNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        return sb.toString();
    }

    @Override
    public String visit(VariableNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        return sb.toString();
    }

    @Override
    public String visit(DeclarationNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        return sb.toString();
    }

    @Override
    public String visit(IfStatementNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        sb.append(this.visit(node.expression));
        
        for (INode child : node.body) {
            sb.append(this.visit(child));
        }

        if (node.child != null) {
            sb.append(this.visit(node.child));
        }

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(ElseStatementNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;
        
        for (INode child : node.body) {
            sb.append(this.visit(child));
        }

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(ElseIfStatementNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        sb.append(this.visit(node.expression));
        
        for (INode child : node.body) {
            sb.append(this.visit(child));
        }

        if (node.child != null) {
            sb.append(this.visit(node.child));
        }

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(BooleanExpressionNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        sb.append(this.visit(node.left));
        sb.append(this.visit(node.right));

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(WhileStatementNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;

        sb.append(this.visit(node.expression));

        for (INode child : node.body) {
            sb.append(this.visit(child));
        }

        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(FunctionParamNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        return sb.toString();
    }

    @Override
    public String visit(FunctionReturnStatementNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;
        sb.append(this.visit(node.expression));
        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(FunctionCallNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;
        for (INode param : node.params) {
            sb.append(this.visit(param));
        }
        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(FunctionCallParamNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;
        sb.append(this.visit(node.expression));
        _depth--;

        return sb.toString();
    }

    @Override
    public String visit(ParenthesesExpressionNode node) {
        StringBuilder sb = new StringBuilder();

        this.addLine(sb);

        sb.append(this.buildIndentation());
        sb.append("+-");
        sb.append(node.getDisplayName());

        _depth++;
        sb.append(this.visit(node.innerExpression));
        _depth--;

        return sb.toString();
    }

}