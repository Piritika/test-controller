package ru.tearose.test_controller.integration.http.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.tearose.test_controller.exception.IncorrectUserDataException;
import ru.tearose.test_controller.exception.UserNotFoundException;
import ru.tearose.test_controller.model.dto.ErrorDto;

@Slf4j
@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerUserNotFoundException(UserNotFoundException e) {
        log.info("start handlerUserNotFoundException");

        ErrorDto errorDto = new ErrorDto()
                .setErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectUserDataException.class)
    public ResponseEntity<ErrorDto> handlerIncorrectUserDataException(IncorrectUserDataException e) {
        log.info("start handlerIncorrectUserDataException");

        ErrorDto errorDto = new ErrorDto()
                .setErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDto> handlerBindException(MethodArgumentTypeMismatchException e) {
        log.info("start handlerBindException");

        ErrorDto errorDto = new ErrorDto()
                .setErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.info("start handlerHttpMessageNotReadableException");

        ErrorDto errorDto = new ErrorDto()
                .setErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handlerException(Exception e) {
        log.info("start handlerException");

        ErrorDto errorDto = new ErrorDto()
                .setErrorMessage("unknown error");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
