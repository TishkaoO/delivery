package ru.fkjob.delivery.web.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.web.service.mail.MessageSender;

@Component
public class CustomerRegisteredEventListener {
    private final MessageSender messageSender;

    public CustomerRegisteredEventListener(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @EventListener
    public void handleCustomerRegisteredEvent(CustomerRegisteredEvent registeredEvent) {
        CustomerEntity customer = registeredEvent.getCustomer();
        String email = customer.getEmail();
        messageSender.sendMessage(email);
    }
}
