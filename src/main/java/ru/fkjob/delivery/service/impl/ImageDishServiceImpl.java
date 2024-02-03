package ru.fkjob.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.dto.image.ImageDishDto;
import ru.fkjob.delivery.exception.NotFoundException;
import ru.fkjob.delivery.domain.DishEntity;
import ru.fkjob.delivery.domain.ImageEntity;
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
        DishEntity dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NotFoundException(String.format("Не найдено блюдо с id = %s", dishId)));
        String imageUrl = minioService.uploadFile(file);
        ImageEntity image = imageRepository.findFirstByDish(dish)
                .map(img -> {
                    img.setUrl(imageUrl);
                    return imageRepository.save(img);
                })
                .orElseGet(() -> {
                    ImageEntity newImage = new ImageEntity();
                    newImage.setUrl(imageUrl);
                    newImage.setDish(dish);
                    return imageRepository.save(newImage);
                });
        return imageDishMapper.toDto(image);
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

    public ImageDishDto getImageByDishId(final Long dishId) {
       return dishRepository.findById(dishId)
                .map(DishEntity::getImage)
                .map(imageEntity -> new ImageDishDto(imageEntity.getId(), imageEntity.getUrl()))
                .orElseThrow(() -> new NotFoundException(String.format("Не найдено блюдо с id = %s", dishId)));
    }
}

