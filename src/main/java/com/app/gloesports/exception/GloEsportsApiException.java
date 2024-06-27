package com.app.gloesports.exception;

import org.springframework.http.HttpStatus;

/**
 * This class is used to handle the exceptions that occur in the GloEsports API
 */
public class GloEsportsApiException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public GloEsportsApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
