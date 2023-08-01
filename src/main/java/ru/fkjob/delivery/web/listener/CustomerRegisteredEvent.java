package ru.fkjob.delivery.web.listener;

import org.springframework.context.ApplicationEvent;
import ru.fkjob.delivery.store.entity.CustomerEntity;

public class CustomerRegisteredEvent extends ApplicationEvent {
    private final CustomerEntity customer;

    public CustomerRegisteredEvent(Object source, CustomerEntity customer) {
        super(source);
        this.customer = customer;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }
}
