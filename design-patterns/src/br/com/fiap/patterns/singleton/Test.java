package br.com.fiap.patterns.singleton;

import br.com.fiap.patterns.factory.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        ObjSingleton obj1 = ObjSingleton.getInstance();
        ObjSingleton obj2 = ObjSingleton.getInstance();

        if(obj1 == obj2) {
            System.out.println("Os dois objetos tem a mesma instância.");
        }

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection(Database.ORACLE);

            if(conn != null) {
                System.out.println("Conexão realizada com sucesso");
                conn.close();
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
