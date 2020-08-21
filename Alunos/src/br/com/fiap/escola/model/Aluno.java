package br.com.fiap.escola.model;

public class Aluno {
	private Integer id;
	private Integer rm;
	private String nome;
	private Boolean ativo;
	private Double nota1;
	private Double nota2;
	
	public Aluno(Integer rm, String nome) {
		this.rm = rm;
		this.nome = nome;
	}

	public Aluno(Integer id, Integer rm, String nome, 
			Boolean ativo, Double nota1, Double nota2) {
		this(rm, nome);
		this.id = id;
		this.ativo = ativo;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Integer getRm() {
		return rm;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return String.format("Aluno: { %s, %s, %s, %s, %s, %s }", 
				id, rm, nome, ativo, nota1, nota2);
	}
	
}
