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

public class PythonVisitor extends ASTVisitor<String> {
    private int _numIndent;
    private Boolean _hasFirstLine = false;

    public PythonVisitor() {
        _numIndent = 0;
    }

    private void addLine(StringBuilder output, INode node) {
        if (node instanceof DeclarationNode) {
            return;
        }
        
        if (_hasFirstLine) {
            output.append("\r\n");
        }        
        else {
            _hasFirstLine = true;
        }
    }

    private void addIndent(StringBuilder output) {
        for (int i = 0; i < _numIndent; i++) {
            output.append("\t");
        }
    }

    @Override
    public String visit(ProgramNode node) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < node.children.size(); i++) {
            INode child = node.children.get(i);
            this.addLine(output, child);

            String temp = this.visit(child);
            output.append(temp);
        }

        return output.toString();
    }

    @Override
    public String visit(BinaryExpressionNode node) {
        StringBuilder output = new StringBuilder();
        output.append(this.visit(node.left));

        switch (node.operation) {
        case ADDITION:
            output.append(" + ");
            break;
        case SUBTRACTION:
            output.append(" - ");
            break;
        case MULTIPLICATION:
            output.append(" * ");
            break;
        case DIVISION:
            output.append(" / ");
            break;
        case POWER:
            output.append(" ^ ");
            break;
        case MODULO:
            output.append(" % ");
            break;
        default:
        }

        output.append(this.visit(node.right));

        return output.toString();
    }

    @Override
    public String visit(AssignmentNode node) {
        StringBuilder output = new StringBuilder();

        output.append(this.visit(node.left));
        switch (node.operation) {
            case ASSIGN:
                output.append(" = ");
                break;
            case ADDITION:
                output.append(" += ");
                break;
            case SUBTRACTION:
                output.append(" -= ");
                break;
            case MULTIPLICATION:
                output.append(" *= ");
                break;
            case DIVISION:
                output.append(" /= ");
                break;
            case POWER:
                output.append(" ^= ");
                break;
            case MODULO:
                output.append(" %= ");
                break;
            default:
            }
        output.append(this.visit(node.right));

        return output.toString();
    }

    @Override
    public String visit(NegateNode node) {
        StringBuilder output = new StringBuilder();

        output.append("-");
        output.append(this.visit(node.innerNode));

        return output.toString();
    }

    @Override
    public String visit(ValueNode node) {
        return node.value.toString();
    }

    @Override
    public String visit(VariableNode node) {
        return node.value;
    }

    @Override
    public String visit(DeclarationNode node) {
        // Python doesn't require declaration of nodes so we can skip any that appear.
        return "";
    }

    @Override
    public String visit(IfStatementNode node) {
        StringBuilder output = new StringBuilder();

        output.append("if ");
        output.append(this.visit(node.expression));
        output.append(":");

        _numIndent++;

        for (INode child : node.body) {
            if(child instanceof DeclarationNode) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }

        _numIndent--;

        if (node.child != null) {
            addLine(output, node.child);
            addIndent(output);
            output.append(this.visit(node.child));
        }

        return output.toString();
    }

    @Override
    public String visit(ElseStatementNode node) {
        StringBuilder output = new StringBuilder();

        output.append("else:");

        _numIndent++;

        for (INode child : node.body) {
            if(child instanceof DeclarationNode) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }

        _numIndent--;

        return output.toString();
    }

    @Override
    public String visit(ElseIfStatementNode node) {
        StringBuilder output = new StringBuilder();

        output.append("elif ");
        output.append(this.visit(node.expression));
        output.append(":");

        _numIndent++;

        for (INode child : node.body) {
            if(child instanceof DeclarationNode) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }

        _numIndent--;

        if (node.child != null) {
            addLine(output, node.child);
            addIndent(output);
            output.append(this.visit(node.child));
        }

        return output.toString();
    }

    @Override
    public String visit(BooleanExpressionNode node) {
        StringBuilder output = new StringBuilder();

        output.append(this.visit(node.left));

        switch (node.operation) {
        case EQUALS:
            output.append(" == ");
            break;
        case NEGATIVEEQUALS:
            output.append(" != ");
            break;
        case GREATERTHAN:
            output.append(" > ");
            break;
        case LESSTHAN:
            output.append(" < ");
            break;
        case GREATERTHANEQUALS:
            output.append(" >= ");
            break;
        case LESSTHANEQUALS:
            output.append(" <= ");
            break;
        case OR:
            output.append(" or ");
            break;
        case AND:
            output.append(" and ");
            break;
        }

        output.append(this.visit(node.right));

        return output.toString();
    }

    @Override
    public String visit(WhileStatementNode node) {
        StringBuilder output = new StringBuilder();

        output.append("while ");
        output.append(this.visit(node.expression));
        output.append(":");

        _numIndent++;

        for (INode child : node.body) {
            if(child instanceof DeclarationNode) {
                continue;
            }
            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }

        _numIndent--;

        return output.toString();
    }

    @Override
    public String visit(FunctionNode node) {
        StringBuilder output = new StringBuilder();

        output.append("def ");
        output.append(node.name);
        output.append("(");
        for (int i = 0; i < node.params.size(); i++) {
            if (i > 0) {
                output.append(", ");
            }

            output.append(this.visit(node.params.get(i)));
        }
        output.append(")");
        output.append(":");

        _numIndent++;

        for (INode child : node.body) {
            if(child instanceof DeclarationNode) {
                continue;
            }

            addLine(output, child);
            addIndent(output);
            output.append(this.visit(child));
        }

        _numIndent--;

        return output.toString();
    }

    @Override
    public String visit(FunctionParamNode node) {
        return node.name;
    }

    @Override
    public String visit(FunctionReturnStatementNode node) {
        StringBuilder output = new StringBuilder();

        output.append("return ");
        output.append(this.visit(node.expression));

        return output.toString();
    }

    @Override
    public String visit(FunctionCallNode node) {
        StringBuilder output = new StringBuilder();

        output.append(node.name);
        output.append("(");
        for (int i = 0; i < node.params.size(); i++) {
            if (i > 0) {
                output.append(", ");
            }

            output.append(this.visit(node.params.get(i)));
        }
        output.append(")");

        return output.toString();
    }

    @Override
    public String visit(FunctionCallParamNode node) {
        return this.visit(node.expression);
    }

    @Override
    public String visit(ParenthesesExpressionNode node) {
        StringBuilder output = new StringBuilder();

        output.append("(");
        output.append(this.visit(node.innerExpression));
        output.append(")");

        return output.toString();
    }
}