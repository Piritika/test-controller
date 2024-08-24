package ru.tearose.test_controller.exception;

import lombok.Getter;

@Getter
public class IncorrectUserDataException extends RuntimeException {

    private final String message;

    public IncorrectUserDataException(String message) {
        this.message = message;
    }
}
