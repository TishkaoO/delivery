package ru.fkjob.delivery.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
public class PaymentException extends RuntimeException {

    public PaymentException(String message) {
        super(message);
    }
}
