package br.com.fiap.patterns.dao.interfaces;

public class Test {

    public static void main(String[] args) {
        PessoaDAO dao = new OraclePessoaDAO();
        // Faço tudo que preciso no Oracle
        dao = new MySQLPessoaDAO();
        // Faço tudo que preciso no MySQL
    }
}
