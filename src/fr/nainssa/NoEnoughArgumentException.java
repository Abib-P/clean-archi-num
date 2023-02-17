package fr.nainssa;

public class NoEnoughArgumentException extends RuntimeException {
    public NoEnoughArgumentException(String message) {
        super(message);
    }
}
