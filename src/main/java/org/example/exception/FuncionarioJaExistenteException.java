package org.example.exception;

public class FuncionarioJaExistenteException extends RuntimeException {
    public FuncionarioJaExistenteException(String message) {
        super(message);
    }
}
