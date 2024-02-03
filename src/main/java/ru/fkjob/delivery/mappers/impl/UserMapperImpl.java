package ru.fkjob.delivery.mappers.impl;

import org.springframework.stereotype.Component;
import ru.fkjob.delivery.domain.UserEntity;
import ru.fkjob.delivery.dto.baseuser.UserDto;
import ru.fkjob.delivery.mappers.user.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserDto user) {
        return UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }
}
