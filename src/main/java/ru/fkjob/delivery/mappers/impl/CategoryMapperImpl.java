package ru.fkjob.delivery.mappers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.fkjob.delivery.dto.category.CategoryDto;
import ru.fkjob.delivery.dto.category.CategoryInfoDto;
import ru.fkjob.delivery.dto.dish.DishDto;
import ru.fkjob.delivery.mappers.category.CategoryMapper;
import ru.fkjob.delivery.mappers.dish.DishMapper;
import ru.fkjob.delivery.entity.CategoryEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryMapperImpl implements CategoryMapper {
    private final DishMapper dishMapper;

    @Override
    public CategoryInfoDto toDtoInfo(CategoryEntity entity) {
        return CategoryInfoDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dishDtos(dishMapper.toDto(entity.getDishEntities()))
                .build();
    }

    @Override
    public CategoryDto toDto(CategoryEntity entity) {
        return CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public List<CategoryDto> toDto(List<CategoryEntity> entity) {
        return entity.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryEntity toEntity(DishDto dto) {
        return CategoryEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public CategoryEntity toEntity(CategoryInfoDto dto) {
        return CategoryEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .dishEntities(dishMapper.toEntity(dto.getDishDtos()))
                .build();
    }

    @Override
    public List<CategoryInfoDto> toDtoInfo(List<CategoryEntity> entity) {
        return entity.stream()
                .map(this::toDtoInfo)
                .collect(Collectors.toList());
    }
}
