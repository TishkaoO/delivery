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
@ApiModel(description = "Информация о товаре в корзине")
public class CartDishInfoDto {

    @ApiModelProperty("Идентификатор блюда")
    private Long id;

    @ApiModelProperty("Название блюда")
    private String name;

    @ApiModelProperty("Фото блюда")
    private ImageDishDto imageDish;

    @ApiModelProperty("Стоимость")
    private Double price;

    @ApiModelProperty("Количество")
    private Integer quantity;

    @ApiModelProperty("Общее количество товара в корзине")
    private Integer totalQuantity;

    @ApiModelProperty("Общая стоимость товара в корзине")
    private Double totalPrice;
}
