package ru.fkjob.delivery.web.dto.mapper;

import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.web.dto.DishDTO;

import java.util.List;

public interface DishMapper {
    DishDTO toDto(DishEntity entity);
    List<DishDTO> toDto(List<DishEntity> entity);
    DishEntity toEntity(DishDTO dto);
}
