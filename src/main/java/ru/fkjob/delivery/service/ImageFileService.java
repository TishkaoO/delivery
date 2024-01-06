package ru.fkjob.delivery.service;

import ru.fkjob.delivery.dto.image.ImageDishDto;

public interface ImageFileService {

    String uploadFile(ImageDishDto dto);
}
