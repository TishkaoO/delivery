package ru.fkjob.delivery.rest.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Категория блюд")
public class CategoryDto {

    @ApiModelProperty(name = "Идентификатор категории")
    private Long id;

    @ApiModelProperty(name = "название категории")
    private String name;
}