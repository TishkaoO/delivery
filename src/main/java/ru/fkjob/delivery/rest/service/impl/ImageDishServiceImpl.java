package ru.fkjob.delivery.rest.service.impl;

import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.rest.dto.image.ImageDishDto;
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

    @SneakyThrows
    public ImageDishDto uploadImage(final Long dishId, final MultipartFile file) {
        String imageUrl = minioService.uploadFile(file);
        ImageEntity image = new ImageEntity();
        image.setUrl(imageUrl);
        image.setDish(dishRepository.findById(dishId).get());
        ImageEntity entity = imageRepository.save(image);
        ImageDishDto dto = new ImageDishDto();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        return dto;
    }

    @SneakyThrows
    public void deleteImage(final Long dishId, final Long imageId) {
        // Получите объект изображения из базы данных по его ID
        DishEntity dish = dishRepository.findById(dishId).get();
        ImageEntity image = imageRepository.findById(imageId).get();
        if (image != null) {
            minioService.deleteFile(image.getUrl());
            imageRepository.deleteById(imageId);
        }
    }
}

