package ru.fkjob.delivery.rest.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fkjob.delivery.rest.dto.dish.DishDto;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "полная информация по категориям блюд")
public class CategoryInfoDto {

    @ApiModelProperty(name = "Идентификатор категории")
    private Long id;

    @ApiModelProperty(name = "название категории")
    private String name;

    @ApiModelProperty(name = "список блюд относящиеся к категории")
    private List<DishDto> dishDtos;
}
