package ru.fkjob.delivery.rest.service;

import ru.fkjob.delivery.rest.dto.category.CategoryDto;
import ru.fkjob.delivery.rest.dto.category.CategoryInfoDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategory();

    CategoryInfoDto getCategoryById(Long id);
}
