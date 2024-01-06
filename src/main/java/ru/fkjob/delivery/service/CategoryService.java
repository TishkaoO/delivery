package ru.fkjob.delivery.service;

import ru.fkjob.delivery.dto.category.CategoryDto;
import ru.fkjob.delivery.dto.category.CategoryInfoDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategory();

    CategoryInfoDto getCategoryById(Long id);

    List<CategoryInfoDto> getAllCategoryDishes();
}
