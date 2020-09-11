package br.com.fiap.banco.exception;

public class CadastroContaException extends Exception {

	private static final long serialVersionUID = 8556982832108508192L;

	public CadastroContaException() {
		this("Problemas no cadastro da conta");
	}

	public CadastroContaException(String msg) {
		super(msg);
	}
}
