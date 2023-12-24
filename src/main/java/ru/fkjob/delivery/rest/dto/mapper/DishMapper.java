package ru.fkjob.delivery.rest.dto.mapper;

import ru.fkjob.delivery.rest.dto.DishDto;
import ru.fkjob.delivery.store.entity.DishEntity;

import java.util.List;

public interface DishMapper {
    DishDto toDto(DishEntity entity);
    List<DishDto> toDto(List<DishEntity> entity);
    DishEntity toEntity(DishDto dto);
}
