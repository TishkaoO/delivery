package ru.fkjob.delivery.dto.cart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Информация о товаре в корзине")
public class CartDishInfoDto {

    @ApiModelProperty("Информация о блюдах в корзине")
    private List<CartItemDishDto> items;

    @ApiModelProperty("Общее количество товара в корзине")
    private Integer totalQuantity;

    @ApiModelProperty("Общая стоимость товара в корзине")
    private Double totalPrice;
}
