package br.com.fiap.patterns.factory;

import java.sql.Connection;
import java.sql.SQLException;

// Reflection
public class ConnectionReflectionFactory {

    public static Connection getConnection(Database database) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("br.com.fiap.patterns.factory." + database.getValue() + "Connection");
        return ((MyConnection) c.newInstance()).getConnection();
    }
}
