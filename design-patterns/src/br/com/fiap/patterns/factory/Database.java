package br.com.fiap.patterns.factory;

public enum Database {
    ORACLE("Oracle"),
    MYSQL("MySQL"),
    MONGO_DB("MongoDB");

    private final String value;

    private Database(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
