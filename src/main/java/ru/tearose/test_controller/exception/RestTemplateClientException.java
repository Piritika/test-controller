package ru.tearose.test_controller.exception;

import lombok.Getter;

@Getter
public class RestTemplateClientException extends RuntimeException {

    private final String message;

    public RestTemplateClientException(String message) {
        this.message = message;
    }
}
