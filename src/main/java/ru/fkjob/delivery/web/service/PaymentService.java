package ru.fkjob.delivery.web.service;

public interface PaymentService {

    boolean toPay(long orderId, long cardId);
}
