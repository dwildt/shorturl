package com.shorturl.javame;

/**
 *
 * @author danielwildt
 */
public class ShortUrlException extends Exception {

    public String getMessage() {
        return super.getMessage();
    }

    public ShortUrlException(String message) {
        super(message);
    }

    public ShortUrlException(String message, Throwable cause) {
        super(message.concat(" -- Caused by ".concat(cause.getMessage())));
    }


}
