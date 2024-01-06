package ru.fkjob.delivery.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.rest.dto.image.ImageDishDto;
import ru.fkjob.delivery.rest.exception.NotFoundException;
import ru.fkjob.delivery.rest.service.minio.MinioService;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.store.entity.ImageEntity;
import ru.fkjob.delivery.store.repository.DishRepository;
import ru.fkjob.delivery.store.repository.ImageFileRepository;

@Service
@RequiredArgsConstructor
public class ImageDishServiceImpl {
    private final ImageFileRepository imageRepository;
    private final MinioService minioService;
    private final DishRepository dishRepository;


    public ImageDishDto uploadImage(final Long dishId, final MultipartFile file) {
        String imageUrl = minioService.uploadFile(file);
        DishEntity dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NotFoundException(String.format("Не найдено блюдо с id = %s", dishId)));
        ImageEntity image = new ImageEntity();
        image.setUrl(imageUrl);
        image.setDish(dish);
        ImageEntity entity = imageRepository.save(image);
        ImageDishDto dto = new ImageDishDto();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        return dto;
    }

    public void deleteImage(final Long dishId, final Long imageId) {
        DishEntity dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NotFoundException(String.format("Не найдено блюдо с id = %s", dishId)));
        ImageEntity image = imageRepository.findById(imageId)
                .orElseThrow(() -> new NotFoundException(String.format("Не найдена фотография с id = %s", imageId)));
        dish.setImage(null);
        dishRepository.save(dish);
        minioService.deleteFile(image.getUrl());
        imageRepository.delete(image);
    }
}

