package com.amsidh.mvc.currencyexchange.controller;

import com.amsidh.mvc.currencyexchange.exception.ErrorMessage;
import com.amsidh.mvc.currencyexchange.exception.MyCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@RestControllerAdvice
public class ExchangeAdviceController {

    @ExceptionHandler(MyCustomException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage badRequestException(MyCustomException ex, WebRequest request) {
        return ErrorMessage.builder()
                .description(request.getDescription(false))
                .message(ex.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .build();
    }


}
