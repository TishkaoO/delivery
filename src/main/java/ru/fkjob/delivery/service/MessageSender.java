package ru.fkjob.delivery.service;

import ru.fkjob.delivery.dto.baseuser.UserDto;

public interface MessageSender {

    String sendMessage(UserDto user);
}
