package ru.fkjob.delivery.rest.dto.image;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Картинка блюда")
public class ImageDishDto {

    @ApiModelProperty(name = "идентификатор картинки")
    private Long id;

    @ApiModelProperty(name = "адрес пути картинки")
    private String url;
}
