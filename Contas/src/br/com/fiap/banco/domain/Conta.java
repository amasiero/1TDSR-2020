package br.com.fiap.banco.domain;

public class Conta { // Tipo por/de referência
	
	private Integer id;
	private Integer numero;
	private String nomeTitular;
	private String cpf;
	private Boolean ativo;
	private Double saldo;
	
	public Conta(Integer numero, String nomeTitular, String cpf) {
		this.numero = numero;
		this.nomeTitular = nomeTitular;
		this.cpf = cpf;
		this.ativo = true;
		this.saldo = 0.0;
	}
	
	public Conta(Integer numero, String nomeTitular, String cpf, Boolean ativo, Double saldo) {
		this(numero, nomeTitular, cpf);
		this.ativo = ativo;
		this.saldo = saldo;
	}
	
	
	public Conta(Integer id, Integer numero, String nomeTitular, String cpf, Boolean ativo, Double saldo) {
		this(numero, nomeTitular, cpf, ativo, saldo);
		this.id = id;
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

	public Integer getNumero() {
		return numero;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void deposita(double valor) {
		if(this.valorPositivo(valor)) {
			this.saldo = this.saldo + valor;
		}
	}
	
	public boolean saca(double valor) {
		if(this.saldoDisponivel(valor) && 
				this.valorPositivo(valor)) {
			this.saldo = this.saldo - valor;
			return true;
		} 
		return false;
	}
	
	public boolean transfere(double valor, Conta conta) {
		if(this.saca(valor)) {
			conta.deposita(valor);
			return true;
		}
		return false;
	}
	
	public boolean saldoDisponivel(double valor) {
		return this.saldo >= valor;
	}
	
	public boolean valorPositivo(double valor) {
		return valor > 0;
	}

	@Override
	public String toString() {
		return String.format("Conta: {\n\tnumero: %s,\n\ttitular: %s,\n\tcpf: %s,\n\tativo: %s, \n\tsaldo: R$ %.2f\n}",
				numero, nomeTitular, cpf, ativo ? "sim" : "nao", saldo);
	}
}
