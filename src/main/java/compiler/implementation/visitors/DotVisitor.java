package compiler.implementation.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import compiler.abstraction.INode;
import compiler.abstraction.dot.DotConnection;
import compiler.abstraction.dot.DotNode;
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
import compiler.utils.DotHelper;

public class DotVisitor extends ASTVisitor<String> {

    private final static String _labelParams = "shape=\"box\"]";
    private ArrayList<DotConnection> _connections = new ArrayList<>();
    private List<String> _connectionsList() {
        return _connections.stream().map(c -> String.format("\"%s\" -> \"%s\";", c.a, c.b)).collect(Collectors.toList());
    }
    private List<String> _connectionDefinitions() {
        return DotHelper.flattenConnections(_connections).stream().map(n -> String.format("\"%s\" [label=\"%s\" %s;", n, n.lable, _labelParams)).collect(Collectors.toList());
    }

    private Stack<DotNode> _nodeStack;

    private DotNode getParent() {
        return _nodeStack.peek();
    }

    public DotVisitor() {
        _nodeStack = new Stack<>();
    }


    @Override
    public String visit(ProgramNode node) {
        _nodeStack.add(new DotNode(node));

        for (INode child : node.children) {
            this.visit(child);
        }

        _nodeStack.pop();

        StringBuilder sb = new StringBuilder();

        sb.append("digraph G {");
        sb.append("\r\n");
        sb.append("rankdir=LR");
        sb.append("\r\n");
        sb.append(String.join("\r\n", _connectionDefinitions()));
        sb.append("\r\n");
        sb.append(String.join("\r\n", _connectionsList()));
        sb.append("\r\n");
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String visit(BinaryExpressionNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.left);
        this.visit(node.right);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(AssignmentNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.left);
        this.visit(node.right);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(NegateNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.innerNode);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(FunctionNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        for (INode param : node.params) {
            this.visit(param);
        }

        for (INode child : node.body) {
            this.visit(child);
        }
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(ValueNode node) {
        _connections.add(new DotConnection(this.getParent(), new DotNode(node)));
        return null;
    }

    @Override
    public String visit(VariableNode node) {
        _connections.add(new DotConnection(this.getParent(), new DotNode(node)));
        return null;
    }

    @Override
    public String visit(DeclarationNode node) {
        _connections.add(new DotConnection(this.getParent(), new DotNode(node)));
        return null;
    }

    @Override
    public String visit(IfStatementNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.expression);

        for (INode child : node.body) {
            this.visit(child);
        }

        if (node.child != null) {
            this.visit(node.child);
        }
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(ElseStatementNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        for (INode child : node.body) {
            this.visit(child);
        }
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(ElseIfStatementNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.expression);

        for (INode child : node.body) {
            this.visit(child);
        }

        if (node.child != null) {
            this.visit(node.child);
        }
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(BooleanExpressionNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.left);
        this.visit(node.right);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(WhileStatementNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.expression);

        for (INode child : node.body) {
            this.visit(child);
        }
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(FunctionParamNode node) {
        _connections.add(new DotConnection(this.getParent(), new DotNode(node)));
        return null;
    }

    @Override
    public String visit(FunctionReturnStatementNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.expression);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(FunctionCallNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        for (INode param : node.params) {
            this.visit(param);
        }
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(FunctionCallParamNode node) {
        _connections.add(new DotConnection(this.getParent(), new DotNode(node)));
        return null;
    }

    @Override
    public String visit(ParenthesesExpressionNode node) {
        DotNode newParent = new DotNode(node);
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.innerExpression);
        _nodeStack.pop();

        return null;
    }

}