package ru.fkjob.delivery.dto.cart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fkjob.delivery.dto.dish.DishItemDto;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Корзина")
public class CartItemDto {

    @ApiModelProperty(name = "Информация количеству добавленных товаров")
    private List<DishItemDto> dishItems;
}
