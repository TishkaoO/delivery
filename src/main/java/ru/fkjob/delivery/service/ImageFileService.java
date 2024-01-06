package ru.fkjob.delivery.service;

import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.dto.image.ImageDishDto;

public interface ImageFileService {

    ImageDishDto uploadImage(final Long dishId, final MultipartFile file);

    void deleteImage(final Long dishId, final Long imageId);
}
