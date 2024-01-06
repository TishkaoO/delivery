package ru.fkjob.delivery.mappers.image;

import ru.fkjob.delivery.dto.image.ImageDishDto;
import ru.fkjob.delivery.entity.ImageEntity;

public interface ImageDishMapper {

    ImageDishDto toDto(ImageEntity entity);

    ImageEntity toEntity(ImageDishDto dto);
}
