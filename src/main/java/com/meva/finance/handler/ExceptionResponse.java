package com.meva.finance.handler;

import com.meva.finance.exception.InvalidFamilyException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionResponse extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidFamilyException.class})
    protected ResponseEntity<?> handlerExcepetion(InvalidFamilyException fe, HttpRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("MensagemTeste: ", "Teste");
        HttpStatus status = HttpStatus.BAD_REQUEST;
        body.put("Mensagem: ", fe.getMessage());
        body.put("time: ", LocalDateTime.now());

        return new ResponseEntity<>(body, status);


    }
}
