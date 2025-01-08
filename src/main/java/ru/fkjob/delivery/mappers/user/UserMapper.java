package ru.fkjob.delivery.mappers.user;

import org.mapstruct.Mapper;
import ru.fkjob.delivery.domain.UserEntity;
import ru.fkjob.delivery.dto.baseuser.UserDto;
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDto baseUserDto);
}
