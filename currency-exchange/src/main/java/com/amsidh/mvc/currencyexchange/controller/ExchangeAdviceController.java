package com.amsidh.mvc.currencyexchange.controller;

import com.amsidh.mvc.currencyexchange.exception.ErrorMessage;
import com.amsidh.mvc.currencyexchange.exception.MyCustomException;
import com.amsidh.mvc.currencyexchange.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ExchangeAdviceController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = ErrorMessage.builder()
                .description(request.getDescription(false))
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .build();

        return message;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = ErrorMessage.builder()
                .description(request.getDescription(false))
                .message(ex.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .build();

        return message;
    }

    @ExceptionHandler(MyCustomException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage resourceNotFoundException(MyCustomException ex, WebRequest request) {
        ErrorMessage message = ErrorMessage.builder()
                .description(request.getDescription(false))
                .message(ex.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .build();

        return message;
    }


}
