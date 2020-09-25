package br.com.fiap.pousada.exception;

public class LoadFileException extends Exception {

    public LoadFileException() {
        this("Não foi posssível carregar o arquivo.");
    }

    public LoadFileException(String msg) {
        super(msg);
    }
}
