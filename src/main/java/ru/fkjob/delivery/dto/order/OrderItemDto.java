package ru.fkjob.delivery.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fkjob.delivery.dto.cart.CartDto;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Заказ")
public class OrderItemDto {

    @ApiModelProperty(name = "Информация, что успешно добавлено")
    private boolean success;

    @ApiModelProperty(name = "Корзина")
    private CartDto cart;
}
