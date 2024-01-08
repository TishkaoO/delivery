package ru.fkjob.delivery.dto.dish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Представляет полную информацию по блюду")
public class DishInfoDto {

    @ApiModelProperty(name = "Идентификатор блюда")
    private Long id;

    @NotEmpty(message = "Пожалуйста укажите название")
    @Pattern(regexp = "^[\\p{L}\\s]*$", message = "Название может содержать только буквы")
    @ApiModelProperty(name = "Название блюда")
    private String name;

    @Min(0)
    @ApiModelProperty(name = "Стоимость блюда")
    private Double price;

    @Pattern(regexp = "^[\\p{L}\\s]*$", message = "Описание может содержать только буквы")
    @ApiModelProperty(name = "Описание блюда")
    private String description;

    //TODO:решить с картинкой
//    @ApiModelProperty(name = "Картинка блюда")
//    private String url;
}
