package br.com.fiap.patterns.factory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        try {
            Connection conn = ConnectionFactory.getConnection(Database.ORACLE);
            if(conn != null) {
                System.out.println("Conectado com sucesso!");
                conn.close();
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection conn2 = ConnectionFactory.getConnection(Database.ORACLE);
            if(conn2 != null) {
                System.out.println("Conectado através de reflection com sucesso!");
                conn2.close();
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
