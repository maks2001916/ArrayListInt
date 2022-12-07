package Exceptions;

public class TheArgumentIsMissingException extends Exception{
    public TheArgumentIsMissingException() {
    }

    public TheArgumentIsMissingException(String message) {
        super(message);
    }
}
