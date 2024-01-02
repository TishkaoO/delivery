package ru.fkjob.delivery.rest.dto.mapper;

import ru.fkjob.delivery.rest.dto.dish.DishDto;
import ru.fkjob.delivery.rest.dto.dish.DishInfoDto;
import ru.fkjob.delivery.store.entity.DishEntity;

import java.util.List;

public interface DishMapper {
    DishInfoDto toDtoInfo(DishEntity entity);

    DishDto toDto(DishEntity entity);
    List<DishDto> toDto(List<DishEntity> entity);
    DishEntity toEntity(DishDto dto);

    DishEntity toEntity(DishInfoDto dto);

    List<DishEntity> toEntity(List<DishDto> entity);
}
