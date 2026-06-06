package model;

public class PlacaInvalidaException extends RuntimeException {
    public PlacaInvalidaException(String mensagem) {
        super(mensagem);
    }
}