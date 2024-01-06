package ru.fkjob.delivery.mappers.impl;

import org.springframework.stereotype.Component;
import ru.fkjob.delivery.dto.image.ImageDishDto;
import ru.fkjob.delivery.entity.ImageEntity;
import ru.fkjob.delivery.mappers.image.ImageDishMapper;

@Component
public class ImageDishMapperImpl implements ImageDishMapper {

    @Override
    public ImageDishDto toDto(ImageEntity entity) {
        return ImageDishDto.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .build();
    }

    @Override
    public ImageEntity toEntity(ImageDishDto dto) {
        return ImageEntity.builder()
                .id(dto.getId())
                .url(dto.getUrl())
                .build();
    }
}
