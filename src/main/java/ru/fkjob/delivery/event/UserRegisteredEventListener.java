package ru.fkjob.delivery.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.fkjob.delivery.dto.baseuser.UserDto;
import ru.fkjob.delivery.service.MessageSender;

@Component
public class UserRegisteredEventListener {
    private final MessageSender messageSender;

    public UserRegisteredEventListener(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        UserDto user = event.getUser();
        messageSender.sendMessage(user);
    }
}
