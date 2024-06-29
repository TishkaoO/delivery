package ru.fkjob.delivery.event;

import org.springframework.context.ApplicationEvent;
import ru.fkjob.delivery.dto.baseuser.UserDto;

public class UserRegisteredEvent extends ApplicationEvent {
    private final UserDto user;

    public UserRegisteredEvent(Object source, UserDto user) {
        super(source);
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }
}
