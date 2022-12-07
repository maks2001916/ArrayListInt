package Exceptions;

public class TheArgumentIsMissingFromTheListException extends Exception{
    public TheArgumentIsMissingFromTheListException() {
    }

    public TheArgumentIsMissingFromTheListException(String message) {
        super(message);
    }
}
