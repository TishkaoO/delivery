package ru.fkjob.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.dto.category.CategoryDto;
import ru.fkjob.delivery.dto.category.CategoryInfoDto;
import ru.fkjob.delivery.mappers.category.CategoryMapper;
import ru.fkjob.delivery.exception.NotFoundException;
import ru.fkjob.delivery.service.CategoryService;
import ru.fkjob.delivery.entity.CategoryEntity;
import ru.fkjob.delivery.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryMapper.toDto(categoryEntities);
    }

    @Override
    public CategoryInfoDto getCategoryById(final Long id) {
       CategoryEntity category = categoryRepository.findById(id)
               .orElseThrow(() -> new NotFoundException(
                       String.format("Не найдена категория с id = %s", id)));
        return categoryMapper.toDtoInfo(category);
    }

    @Override
    public List<CategoryInfoDto> getAllCategoryDishes() {
        List<CategoryEntity> category = categoryRepository.findAll();
        return categoryMapper.toDtoInfo(category);
    }
}
