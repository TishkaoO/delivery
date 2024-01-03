package ru.fkjob.delivery.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.rest.dto.dish.DishDto;
import ru.fkjob.delivery.rest.dto.dish.DishInfoDto;
import ru.fkjob.delivery.store.entity.CategoryEntity;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.store.repository.CategoryRepository;
import ru.fkjob.delivery.store.repository.DishRepository;
import ru.fkjob.delivery.rest.dto.mapper.DishMapper;
import ru.fkjob.delivery.rest.service.DishService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;
    private final DishMapper dishMapper;

    @Override
    public DishInfoDto getDishEntityById(long id) {
        return dishRepository.findById(id)
                .map(entity -> dishMapper.toDtoInfo(entity))
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public List<DishDto> getDishByName(String name) {
        List<DishEntity> dishEntities = dishRepository.findDishEntitiesByName(name);
        return dishMapper.toDto(dishEntities);
    }

    @Override
    public List<DishDto> getDishList() {
        List<DishEntity> entities = dishRepository.findAll();
        return dishMapper.toDto(entities);
    }

    @Override
    public DishInfoDto save(Long categoryId, DishInfoDto dishInfoDto) {
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("category is not found"));
        DishEntity entity = dishMapper.toEntity(dishInfoDto);
        entity.setCategoryEntity(category);
        DishEntity save = dishRepository.save(entity);
        return dishMapper.toDtoInfo(save);
    }

    @Override
    public void deleteDishEntityById(long id) {
        DishEntity dish = dishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
        dishRepository.delete(dish);
    }

    @Override
    public Long updateDish(long dishId, DishInfoDto dishInfoDto) {
        DishEntity dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
        dish.setName(dishInfoDto.getName());
        dish.setPrice(dishInfoDto.getPrice());
        dish.setDescription(dishInfoDto.getDescription());
        return dishRepository.save(dish).getId();
    }
}
