package exceptions;

public class MyArrayDataException extends ArrayException {

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArrayDataException() {
    }
}
