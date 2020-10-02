package br.com.fiap.patterns.model;

import java.time.LocalDate;

public class Pessoa {
    private Long id;
    private String nome;
    private String endereco;
    private String email;
    private Boolean ativo;
    private LocalDate dataNascimento;
    private String telefone;

    public Pessoa(Long id, String nome, String endereco, String email, Boolean ativo, LocalDate dataNascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.ativo = ativo;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }
}
