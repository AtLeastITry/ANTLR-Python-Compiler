package ce305.utils;

import ce305.abstraction.DataType;
import ce305.abstraction.expressions.FunctionCallNode;
import ce305.abstraction.functions.FunctionNode;
import ce305.abstraction.functions.FunctionParamNode;
import ce305.implementation.visitors.DataTypeRetriever;

public class FunctionNameDefinition {
    public final String name;
    public final DataType[] paramsTypes;

    public FunctionNameDefinition(FunctionNode node) {
        this.name = node.name;
        paramsTypes = new DataType[node.params.size()];

        for (int i = 0; i < node.params.size(); i++) {
            paramsTypes[i] = node.params.get(i).dataType;
        }
    }

    public FunctionNameDefinition(FunctionCallNode node, SymbolTable table) {
        this.name = node.name;
        paramsTypes = new DataType[node.params.size()];

        DataTypeRetriever dataTypeRetriever = new DataTypeRetriever(table);

        for (int i = 0; i < node.params.size(); i++) {
            paramsTypes[i] = dataTypeRetriever.visit(node.params.get(i));
        }
    }

    public String getDataTypeParams() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.paramsTypes.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }

            sb.append(this.paramsTypes[i]);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name);

        for (DataType param : this.paramsTypes) {
            sb.append("_");
            sb.append(param);
        }

        return sb.toString();
    }
}