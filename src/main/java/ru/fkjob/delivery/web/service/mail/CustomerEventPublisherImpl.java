package ru.fkjob.delivery.web.service.mail;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.web.listener.CustomerRegisteredEvent;

@Component
public class CustomerEventPublisherImpl implements CustomerEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public CustomerEventPublisherImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishCustomerRegisteredEvent(CustomerEntity customer) {
        eventPublisher.publishEvent(new CustomerRegisteredEvent(this, customer));
    }
}
