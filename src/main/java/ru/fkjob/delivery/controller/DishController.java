package ru.fkjob.delivery.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.dto.image.ImageDishDto;
import ru.fkjob.delivery.service.ImageFileService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dishes")
@Api(tags = "для работы с блюдом")
@RequiredArgsConstructor
public class DishController {
    private final ImageFileService fileService;

    @PutMapping(value = "/{dishId}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Загрузить изображение для блюда")
    public void uploadImage(@PathVariable("dishId") final Long dishId, @RequestPart("file") final MultipartFile file) {
         fileService.uploadImage(dishId, file);
    }

    @DeleteMapping(value = "/{dishId}/image")
    @Operation(summary = "удалить изображение для блюда")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable("dishId") final Long dishId, @RequestParam("id") final Long id) {
        fileService.deleteImage(dishId, id);
    }
}
