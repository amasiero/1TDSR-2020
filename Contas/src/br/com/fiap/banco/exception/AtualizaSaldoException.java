package br.com.fiap.banco.exception;

public class AtualizaSaldoException extends Exception {

	private static final long serialVersionUID = -3123437156597195782L;

	public AtualizaSaldoException() {
		this("Problemas na atualiza��o da conta");
	}

	public AtualizaSaldoException(String msg) {
		super(msg);
	}
}
