package ru.fkjob.delivery.rest.dto.mapper;

import ru.fkjob.delivery.rest.dto.category.CategoryDto;
import ru.fkjob.delivery.rest.dto.category.CategoryInfoDto;
import ru.fkjob.delivery.rest.dto.dish.DishDto;
import ru.fkjob.delivery.rest.dto.dish.DishInfoDto;
import ru.fkjob.delivery.store.entity.CategoryEntity;
import ru.fkjob.delivery.store.entity.DishEntity;

import java.util.List;

public interface CategoryMapper {

    CategoryInfoDto toDtoInfo(CategoryEntity entity);

    CategoryDto toDto(CategoryEntity entity);

    List<CategoryDto> toDto(List<CategoryEntity> entity);

    CategoryEntity toEntity(DishDto dto);

    CategoryEntity toEntity(CategoryInfoDto dto);
}
