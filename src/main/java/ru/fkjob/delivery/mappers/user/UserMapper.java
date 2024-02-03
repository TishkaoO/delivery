package ru.fkjob.delivery.mappers.user;

import ru.fkjob.delivery.domain.UserEntity;
import ru.fkjob.delivery.dto.baseuser.UserDto;

public interface UserMapper {

    UserEntity toEntity(UserDto baseUserDto);
}
