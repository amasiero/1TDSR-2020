package br.com.fiap.patterns.dao.generics;

public class Test {
    public static void main(String[] args) {
        DAO<?> dao = new PessoaDAO(); // Declaração coringa
        // Tudo que for preciso com a Pessoa
        dao = new NumeroDAO();
        // Tudo que for preciso com o Numero

        DAO<String> pessoaDao = new PessoaDAO(); // Declaração de um tipo
    }
}
