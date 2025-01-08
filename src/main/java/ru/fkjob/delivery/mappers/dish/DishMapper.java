package ru.fkjob.delivery.mappers.dish;

import org.mapstruct.Mapper;
import ru.fkjob.delivery.domain.DishEntity;
import ru.fkjob.delivery.dto.dish.DishDto;
import ru.fkjob.delivery.dto.dish.DishInfoDto;

import java.util.List;
@Mapper(componentModel = "spring")
public interface DishMapper {
    DishInfoDto toDtoInfo(DishEntity entity);

    DishDto toDto(DishEntity entity);
    List<DishDto> toDto(List<DishEntity> entity);
    DishEntity toEntity(DishDto dto);

    DishEntity toEntity(DishInfoDto dto);

    List<DishEntity> toEntity(List<DishDto> dtos);
}
