package ru.fkjob.delivery.rest.dto.mapper.impl;

import org.springframework.stereotype.Component;
import ru.fkjob.delivery.rest.dto.dish.DishDto;
import ru.fkjob.delivery.rest.dto.dish.DishInfoDto;
import ru.fkjob.delivery.rest.dto.mapper.DishMapper;
import ru.fkjob.delivery.store.entity.DishEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapperImpl implements DishMapper {

    @Override
    public DishInfoDto toDtoInfo(DishEntity entity) {
        return DishInfoDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public DishDto toDto(DishEntity entity) {
        return DishDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public List<DishDto> toDto(List<DishEntity> entity) {
        return entity.stream()
                .map(dishEntity -> toDto(dishEntity))
                .collect(Collectors.toList());
    }

    @Override
    public DishEntity toEntity(DishDto dto) {
        return DishEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public DishEntity toEntity(DishInfoDto dto) {
        return DishEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }
}
