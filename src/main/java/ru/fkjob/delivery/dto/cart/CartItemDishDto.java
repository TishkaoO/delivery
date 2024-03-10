package ru.fkjob.delivery.dto.cart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fkjob.delivery.dto.image.ImageDishDto;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Модель описывает блюдо в корзине")
public class CartItemDishDto {
    @ApiModelProperty("Идентификатор блюда")
    private Long dishId;

    @ApiModelProperty("Название блюда")
    private String name;

    @ApiModelProperty("Фото блюда")
    private ImageDishDto imageDish;

    @ApiModelProperty("Стоимость")
    private Double price;

    @ApiModelProperty("Количество")
    private Integer quantity;
}
