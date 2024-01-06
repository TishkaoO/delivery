package ru.fkjob.delivery.dto.dish;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

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

    @ApiModelProperty(name = "картинка блюда")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> images;
}
