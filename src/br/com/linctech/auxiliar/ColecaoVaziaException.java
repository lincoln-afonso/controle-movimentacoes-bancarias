package br.com.linctech.auxiliar;

public class ColecaoVaziaException extends Exception {
    private static final long serialVersionUID = 1L;

    public ColecaoVaziaException(String str) {
        super(str);
    }

    public ColecaoVaziaException() {
        super();
    }
}