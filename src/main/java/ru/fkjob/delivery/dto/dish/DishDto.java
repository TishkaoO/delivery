package ru.fkjob.delivery.dto.dish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Блюдо")
public class DishDto {

    @ApiModelProperty(name = "Идентификатор блюда")
    private Long id;

    @ApiModelProperty(name = "Название блюда")
    private String name;

    @ApiModelProperty(name = "Стоимость блюда")
    private Double price;

    @ApiModelProperty(name = "Количество для заказа")
    private Integer count;
}
