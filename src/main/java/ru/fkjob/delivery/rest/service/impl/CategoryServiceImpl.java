package ru.fkjob.delivery.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.rest.dto.category.CategoryDto;
import ru.fkjob.delivery.rest.dto.category.CategoryInfoDto;
import ru.fkjob.delivery.rest.dto.mapper.CategoryMapper;
import ru.fkjob.delivery.rest.service.CategoryService;
import ru.fkjob.delivery.store.entity.CategoryEntity;
import ru.fkjob.delivery.store.repository.CategoryRepository;

import javax.persistence.EntityNotFoundException;
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
    public CategoryInfoDto getCategoryById(Long id) {
       CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("category is not found"));
        return categoryMapper.toDtoInfo(category);
    }
}
