package ru.fkjob.delivery.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.rest.dto.file.FileMetadataDto;
import ru.fkjob.delivery.rest.service.FileService;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
@Api(tags = "Файлы")
public class FileController {

    private final FileService fileService;

    @ApiOperation("Загрузить файл")
    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileMetadataDto uploadFile(@RequestPart("file") MultipartFile file) {
        return fileService.uploadFile(file.getResource());
    }

    @ApiOperation("Удалить файл")
    @DeleteMapping("/{fileId}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileId) {
        return ResponseEntity.ok(fileService.deleteFile(fileId));
    }
}
