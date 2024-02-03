package ru.fkjob.delivery.mappers.image;

import ru.fkjob.delivery.dto.image.ImageDishDto;
import ru.fkjob.delivery.domain.ImageEntity;

public interface ImageDishMapper {

    ImageDishDto toDto(ImageEntity entity);

    ImageEntity toEntity(ImageDishDto dto);
}
