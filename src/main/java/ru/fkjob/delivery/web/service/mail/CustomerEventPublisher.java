package ru.fkjob.delivery.web.service.mail;

import ru.fkjob.delivery.store.entity.CustomerEntity;

public interface CustomerEventPublisher {
    void publishCustomerRegisteredEvent(CustomerEntity customer);
}
