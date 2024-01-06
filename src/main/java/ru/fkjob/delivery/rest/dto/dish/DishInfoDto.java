package ru.fkjob.delivery.rest.dto.dish;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fkjob.delivery.rest.dto.image.ImageDishDto;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Представляет полную информацию по блюду")
public class DishInfoDto {

    private Long id;

    @ApiModelProperty(name = "Название блюда")
    private String name;

    @ApiModelProperty(name = "стоимость блюда")
    private Double price;

    @ApiModelProperty(name = "описание блюда")
    private String description;
}
