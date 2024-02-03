package ru.fkjob.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.dto.baseuser.UserDto;
import ru.fkjob.delivery.event.UserRegisteredEvent;

@Service
@RequiredArgsConstructor
public class UserEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public void publishUserRegisteredEvent(UserDto registeredUser) {
        eventPublisher.publishEvent(new UserRegisteredEvent(this, registeredUser));
    }
}
