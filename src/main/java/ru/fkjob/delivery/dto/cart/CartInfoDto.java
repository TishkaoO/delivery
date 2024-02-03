package ru.fkjob.delivery.dto.cart;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Информация находящаяся в корзине")
public class CartInfoDto {

    private List<CartDishInfoDto> dishCartInfos;
}
