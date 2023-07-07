package com.meva.finance.exception.handlerException;

import com.meva.finance.exception.entityException.FieldMessage;
import com.meva.finance.exception.entityException.ValidFamilyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerApi {


    @ExceptionHandler(ValidFamilyException.class)
    public ResponseEntity<FieldMessage> validFamilyHandler(ValidFamilyException ex) {
        FieldMessage message = new FieldMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }


}
