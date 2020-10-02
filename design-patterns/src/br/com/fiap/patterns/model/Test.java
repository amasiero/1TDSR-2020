package br.com.fiap.patterns.model;

import br.com.fiap.patterns.model.dto.PessoaDTO;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1L, "Andrey",
                "Onde o Judas perdeu as botas",
                "eu@eu.com", true,
                LocalDate.of(1983, 10, 29), "555-1234");
        exibePessoa(new PessoaDTO(pessoa));
    }

    public static void exibePessoa(PessoaDTO pessoa) {
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getEmail());
    }
}
