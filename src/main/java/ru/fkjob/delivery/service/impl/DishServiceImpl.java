package ru.fkjob.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.dto.dish.DishDto;
import ru.fkjob.delivery.dto.dish.DishInfoDto;
import ru.fkjob.delivery.exception.NotFoundException;
import ru.fkjob.delivery.service.DishService;
import ru.fkjob.delivery.entity.CategoryEntity;
import ru.fkjob.delivery.entity.DishEntity;
import ru.fkjob.delivery.repository.CategoryRepository;
import ru.fkjob.delivery.repository.DishRepository;
import ru.fkjob.delivery.mappers.dish.DishMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;
    private final DishMapper dishMapper;

    @Override
    public DishInfoDto getDishEntityById(final Long id) {
        return dishRepository.findById(id)
                .map(entity -> dishMapper.toDtoInfo(entity))
                .orElseThrow(() -> new NotFoundException(
                        String.format("Не найдено блюдо с id = %s", id)));
    }

    @Override
    public List<DishDto> getDishByName(final String name) {
        List<DishEntity> dishEntities = dishRepository.findDishEntitiesByName(name);
        return dishMapper.toDto(dishEntities);
    }

    @Override
    public List<DishDto> getDishList() {
        List<DishEntity> entities = dishRepository.findAll();
        return dishMapper.toDto(entities);
    }

    @Override
    public DishInfoDto save(final DishInfoDto dishInfoDto, final Long categoryId) {
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Не найдена категория с id = %s", categoryId)));
        DishEntity entity = dishMapper.toEntity(dishInfoDto);
        entity.setCategoryEntity(category);
        DishEntity save = dishRepository.save(entity);
        return dishMapper.toDtoInfo(save);
    }

    @Override
    public void deleteDishEntityById(final Long id) {
        DishEntity dish = dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Не найдено блюдо с id = %s", id)));
        dishRepository.delete(dish);
    }

    @Override
    public Long updateDish(final Long dishId, final DishInfoDto dishInfoDto) {
        DishEntity dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Не найдено блюдо с id = %s", dishId)));
        dish.setName(dishInfoDto.getName());
        dish.setPrice(dishInfoDto.getPrice());
        dish.setDescription(dishInfoDto.getDescription());
        return dishRepository.save(dish).getId();
    }
}
