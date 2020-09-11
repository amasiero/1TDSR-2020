package br.com.fiap.banco.exception;

public class ConexaoException extends Exception {

	private static final long serialVersionUID = 6843888101533259221L;

	public ConexaoException() {
		this("Problemas na conexão");
	}

	public ConexaoException(String msg) {
		super(msg);
	}
}
