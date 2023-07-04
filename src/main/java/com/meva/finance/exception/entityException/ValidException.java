package com.meva.finance.exception.entityException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidException extends RuntimeException{

    public ValidException(String message) {
        super(message);
    }
}