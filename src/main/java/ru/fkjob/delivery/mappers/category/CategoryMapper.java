package ru.fkjob.delivery.mappers.category;

import org.mapstruct.Mapper;
import ru.fkjob.delivery.dto.category.CategoryDto;
import ru.fkjob.delivery.dto.category.CategoryInfoDto;
import ru.fkjob.delivery.domain.CategoryEntity;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryInfoDto toDtoInfo(CategoryEntity entity);


    CategoryDto toDto(CategoryEntity entity);

    List<CategoryDto> toDto(List<CategoryEntity> entity);
}
