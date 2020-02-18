package Stream.Medals;

public class MyOwnException extends RuntimeException {
    public MyOwnException() {
        super();
    }

    public MyOwnException(final String message) {
        super(message);
    }

    public MyOwnException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyOwnException(final Throwable cause) {
        super(cause);
    }

    public MyOwnException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
