package ru.fkjob.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.dto.image.ImageDishDto;
import ru.fkjob.delivery.exception.NotFoundException;
import ru.fkjob.delivery.entity.DishEntity;
import ru.fkjob.delivery.entity.ImageEntity;
import ru.fkjob.delivery.mappers.image.ImageDishMapper;
import ru.fkjob.delivery.repository.DishRepository;
import ru.fkjob.delivery.repository.ImageFileRepository;
import ru.fkjob.delivery.service.ImageFileService;
import ru.fkjob.delivery.service.MinioService;

@Service
@RequiredArgsConstructor
public class ImageDishServiceImpl implements ImageFileService {
    private final ImageFileRepository imageRepository;
    private final MinioService minioService;
    private final DishRepository dishRepository;
    private final ImageDishMapper imageDishMapper;

    @Override
    public ImageDishDto uploadImage(final Long dishId, final MultipartFile file) {
        String imageUrl = minioService.uploadFile(file);
        DishEntity dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NotFoundException(String.format("Не найдено блюдо с id = %s", dishId)));
        ImageEntity image = new ImageEntity();
        image.setUrl(imageUrl);
        image.setDish(dish);
        ImageEntity entity = imageRepository.save(image);
        return imageDishMapper.toDto(entity);
    }

    @Override
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

