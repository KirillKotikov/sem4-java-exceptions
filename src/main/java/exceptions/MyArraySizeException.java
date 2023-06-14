package exceptions;

public class MyArraySizeException extends ArrayException {
    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArraySizeException() {
    }
}
