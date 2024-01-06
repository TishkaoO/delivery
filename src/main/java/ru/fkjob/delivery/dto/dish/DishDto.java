package ru.fkjob.delivery.dto.dish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import ru.fkjob.delivery.dto.image.ImageDishDto;

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

    //TODO:решить с картинкой
//    @ApiModelProperty(name = "Картинка блюда")
//    private String url;
}
