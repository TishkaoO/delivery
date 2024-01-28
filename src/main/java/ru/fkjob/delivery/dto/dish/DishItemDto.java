package ru.fkjob.delivery.dto.dish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Блюдо в заказе")
public class DishItemDto {

    @ApiModelProperty("Идентификатор блюда")
    private Long id;

    @ApiModelProperty("Количество в заказе данного блюда")
    private Integer count;
}
