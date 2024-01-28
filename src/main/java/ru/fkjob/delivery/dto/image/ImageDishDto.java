package ru.fkjob.delivery.dto.image;

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
@ApiModel(description = "Картинка блюда")
public class ImageDishDto {

    @ApiModelProperty(name = "Идентификатор картинки")
    private Long id;

    @ApiModelProperty(name = "Адрес пути картинки")
    private String url;
}
