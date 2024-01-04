package ru.fkjob.delivery.rest.dto.file;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(value = "FileMetadataDto", description = "Метаданные файла")
public class FileMetadataDto {
    @ApiModelProperty("ID файла в ФХ")
    private String fileId;

    @ApiModelProperty("Название файла с расширением")
    private String fileName;

    @ApiModelProperty("Размер файла")
    private Long fileSize;

    @ApiModelProperty("Дата и время загрузки файла в ФХ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdDate;
}
