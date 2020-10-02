package br.com.fiap.patterns.model.dto;

import br.com.fiap.patterns.model.Pessoa;

// DTO -> Data Transfer Object - Objeto de transferencia de dados
// J2EE
public class PessoaDTO {

    private String nome;
    private String email;

    public PessoaDTO(Pessoa pessoa) {
        nome = pessoa.getNome();
        email = pessoa.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
