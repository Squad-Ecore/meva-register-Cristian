package com.meva.finance.exception.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidFamilyException extends RuntimeException {

    public ValidFamilyException(String ex) {
        super(ex);
    }
}
