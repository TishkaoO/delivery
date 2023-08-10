package ru.fkjob.delivery.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.fkjob.delivery.web.exception.PaymentException;

@ControllerAdvice
@Slf4j
public class PaymentExceptionHandler {

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<String> handleException(PaymentException e) {
        log.error(e.getMessage());
        return ResponseEntity.ok(e.getMessage());
    }
}
