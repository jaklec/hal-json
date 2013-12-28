package se.jaklec.hal.json;

public class HalBuilderException extends Exception {

    public HalBuilderException() {
    }

    public HalBuilderException(String message) {
        super(message);
    }

    public HalBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public HalBuilderException(Throwable cause) {
        super(cause);
    }

    public HalBuilderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
