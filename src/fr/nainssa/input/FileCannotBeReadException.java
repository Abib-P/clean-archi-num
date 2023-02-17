package fr.nainssa.input;

public class FileCannotBeReadException extends RuntimeException{
    public FileCannotBeReadException(String message) {
        super(message);
    }
}
