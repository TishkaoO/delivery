package ru.fkjob.delivery.mappers.image;

import org.mapstruct.Mapper;
import ru.fkjob.delivery.dto.image.ImageDishDto;
import ru.fkjob.delivery.domain.ImageEntity;
@Mapper(componentModel = "spring")
public interface ImageDishMapper {

    ImageDishDto toDto(ImageEntity entity);

    ImageEntity toEntity(ImageDishDto dto);
}
