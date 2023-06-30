package com.meva.finance.exception;

import lombok.Data;

@Data
public class InvalidFamilyException extends RuntimeException{
    public InvalidFamilyException(String message) {
        super(message);
    }

    public InvalidFamilyException(String message, Throwable cause){
        super(message, cause);
    }
}
