package ce305.abstraction.utils;

import ce305.abstraction.DataType;

public class Symbol {
    public final String name;
    public final DataType dataType;
    public Scope scope;

    public Symbol(String name, DataType dataType) {
        super();
        this.name = name;
        this.dataType = dataType;
    }
}