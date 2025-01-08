package ru.fkjob.delivery.dto.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fkjob.delivery.dto.dish.DishDto;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Полная информация по категориям блюд")
public class CategoryInfoDto {

    @ApiModelProperty(name = "Идентификатор категории")
    private Long id;

    @ApiModelProperty(name = "Название категории")
    private String name;

    @ApiModelProperty(name = "Список блюд относящиеся к категории")
    private List<DishDto> dishes;
}
