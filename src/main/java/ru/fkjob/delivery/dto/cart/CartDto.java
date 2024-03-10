package ru.fkjob.delivery.dto.cart;

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
@ApiModel(description = "Корзина")
public class CartDto {

    @ApiModelProperty(name = "Идентификатор корзины")
    private Long id;

    @ApiModelProperty(name = "Информация, что успешно добавлено")
    private boolean success;

    @ApiModelProperty(name = "Товар в корзине")
    private CartItemDto cart;
}
