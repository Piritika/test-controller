package ru.tearose.test_controller.exception;

import lombok.Getter;

@Getter
public class InternalServiceException extends RuntimeException {

    private final String message;

    public InternalServiceException() {
        this.message = "internal server error";
    }

    public InternalServiceException(String message) {
        this.message = message;
    }
}
