package ce305.implementation.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import ce305.abstraction.INode;
import ce305.abstraction.dot.DotConnection;
import ce305.abstraction.dot.DotNode;
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
import ce305.implementation.utils.DotHelper;

public class DotVisitor extends ASTVisitor<String> {

    private final static String _labelParams = "shape=\"ellipse\" fontsize=8 width=5 height=1]";
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
        _nodeStack.add(new DotNode(node.getDisplayName()));

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
        DotNode newParent = new DotNode(node.getDisplayName());
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.left);
        this.visit(node.right);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(AssignmentNode node) {
        DotNode newParent = new DotNode(node.getDisplayName());
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.left);
        this.visit(node.right);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(NegateNode node) {
        DotNode newParent = new DotNode(node.getDisplayName());
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.innerNode);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(FunctionNode node) {
        DotNode newParent = new DotNode(node.getDisplayName());
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
        _connections.add(new DotConnection(this.getParent(), new DotNode(node.getDisplayName())));
        return null;
    }

    @Override
    public String visit(VariableNode node) {
        _connections.add(new DotConnection(this.getParent(), new DotNode(node.getDisplayName())));
        return null;
    }

    @Override
    public String visit(DeclarationNode node) {
        _connections.add(new DotConnection(this.getParent(), new DotNode(node.getDisplayName())));
        return null;
    }

    @Override
    public String visit(IfStatementNode node) {
        DotNode newParent = new DotNode(node.getDisplayName());
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
        DotNode newParent = new DotNode(node.getDisplayName());
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
        DotNode newParent = new DotNode(node.getDisplayName());
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
        DotNode newParent = new DotNode(node.getDisplayName());
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.left);
        this.visit(node.right);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(WhileStatementNode node) {
        DotNode newParent = new DotNode(node.getDisplayName());
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
        _connections.add(new DotConnection(this.getParent(), new DotNode(node.getDisplayName())));
        return null;
    }

    @Override
    public String visit(FunctionReturnStatementNode node) {
        DotNode newParent = new DotNode(node.getDisplayName());
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.expression);
        _nodeStack.pop();

        return null;
    }

    @Override
    public String visit(FunctionCallNode node) {
        DotNode newParent = new DotNode(node.getDisplayName());
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
        _connections.add(new DotConnection(this.getParent(), new DotNode(node.getDisplayName())));
        return null;
    }

    @Override
    public String visit(ParenthesesExpressionNode node) {
        DotNode newParent = new DotNode(node.getDisplayName());
        _connections.add(new DotConnection(this.getParent(), newParent));

        _nodeStack.add(newParent);
        this.visit(node.innerExpression);
        _nodeStack.pop();

        return null;
    }

}