package ru.fkjob.delivery.rest.dto.mapper.impl;

import org.springframework.stereotype.Component;
import ru.fkjob.delivery.rest.dto.DishDto;
import ru.fkjob.delivery.rest.dto.mapper.DishMapper;
import ru.fkjob.delivery.store.entity.DishEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapperImpl implements DishMapper {

    @Override
    public DishDto toDto(DishEntity entity) {
        return DishDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
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
                .price(dto.getPrice())
                .build();
    }
}
