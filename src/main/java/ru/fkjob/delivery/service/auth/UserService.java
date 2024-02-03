package ru.fkjob.delivery.service.auth;

import ru.fkjob.delivery.domain.UserEntity;
import ru.fkjob.delivery.dto.baseuser.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> getByUsername(String username);

    Long createOrUpdateUser(UserDto request);
}
