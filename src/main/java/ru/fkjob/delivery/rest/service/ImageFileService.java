package ru.fkjob.delivery.rest.service;

import ru.fkjob.delivery.rest.dto.image.ImageDishDto;

public interface ImageFileService {

    String uploadFile(ImageDishDto dto);
}
