package ru.fkjob.delivery.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.rest.dto.image.ImageDishDto;
import ru.fkjob.delivery.rest.service.impl.ImageDishServiceImpl;
import ru.fkjob.delivery.store.entity.ImageEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dishes")
@Api(tags = "для работы с блюдом")
@RequiredArgsConstructor
public class DishController {
    private final ImageDishServiceImpl fileService;

    @PostMapping(value = "/{dishId}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Загрузить изображение для блюда")
    public ImageDishDto uploadImage(@PathVariable("dishId") final Long dishId, @RequestPart("file") final MultipartFile file) {
        return fileService.uploadImage(dishId, file);
    }

        @DeleteMapping(value = "/{dishId}/image")
        @Operation(summary = "удалить изображение для блюда")
        @ResponseStatus(code = HttpStatus.NO_CONTENT)
        public void deleteImage(@PathVariable("dishId") final Long dishId, @RequestParam("fileId") final Long fileId) {
            fileService.deleteImage(dishId, fileId);
        }
    //
//    @PutMapping(value = "/{dishId}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    @Operation(summary = "обновить изображение для блюда")
//    public ImageDishDto updateImage(@PathVariable("dishId") final Long dishId, @RequestPart("file") final MultipartFile file) {
//        return fileService.updateFile(dishId, file);
//    }
}
