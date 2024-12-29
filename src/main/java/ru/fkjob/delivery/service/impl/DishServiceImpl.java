package ru.fkjob.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.dto.dish.DishDto;
import ru.fkjob.delivery.dto.dish.DishInfoDto;
import ru.fkjob.delivery.exception.NotFoundException;
import ru.fkjob.delivery.service.DishService;
import ru.fkjob.delivery.domain.CategoryEntity;
import ru.fkjob.delivery.domain.DishEntity;
import ru.fkjob.delivery.repository.CategoryRepository;
import ru.fkjob.delivery.repository.DishRepository;
import ru.fkjob.delivery.mappers.dish.DishMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;
    private final DishMapper dishMapper;

    @Override
    public DishInfoDto getDishEntityById(final Long id) {
        return dishRepository.findById(id)
                .map(dishMapper::toDtoInfo)
                .orElseThrow(() -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    String.format("Не найдено блюдо с id = %s", id));
                            log.warn("getDishEntityById: {}", notFoundException.getMessage());
                            return notFoundException;
                        }
                );
    }

    @Override
    public List<DishDto> getDishByName(final String name) {
        Pageable pageable = PageRequest.of(0, 10); // ограничила количество элементов
        List<DishEntity> dishEntities = dishRepository.findDishEntitiesByNameStartWithName(name, pageable); //pageable редактировала
        if (dishEntities.isEmpty()) {
            Pageable pageable1 = PageRequest.of(0, 10); // ограничила количество элементов
            List<DishEntity> dish = dishRepository.findDishEntitiesByName(name, pageable1);
            return dishMapper.toDto(dish);
        }
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
                .orElseThrow(() -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    String.format("Не найдена категория с id = %s", categoryId));
                            log.warn("getDishEntityById: {}", notFoundException.getMessage());
                            return notFoundException;
                        }
                );
        DishEntity entity = dishMapper.toEntity(dishInfoDto);
        entity.setCategory(category);
        DishEntity save = dishRepository.save(entity);
        return dishMapper.toDtoInfo(save);
    }

    @Override
    public void deleteDishEntityById(final Long id) {
        DishEntity dish = dishRepository.findById(id)
                .orElseThrow(() -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    String.format("Не найдено блюдо с id = %s", id));
                            log.debug("getDishEntityById: {}", notFoundException.getMessage());
                            return notFoundException;
                        }
                );
        dishRepository.delete(dish);
    }

    @Override
    public Long updateDish(final Long dishId, final DishInfoDto dishInfoDto) {
        DishEntity dish = dishRepository.findById(dishId)
                .orElseThrow(() -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    String.format("Не найдено блюдо с id = %s", dishId));
                            log.debug("getDishEntityById: {}", notFoundException.getMessage());
                            return notFoundException;
                        }
                );
        dish.setName(dishInfoDto.getName());
        dish.setPrice(dishInfoDto.getPrice());
        dish.setDescription(dishInfoDto.getDescription());
        return dishRepository.save(dish).getId();
    }

    @Override
    public List<DishDto> getDishByIsStock() {
        List<DishEntity> entities = dishRepository.findDishEntitiesByStockIsTrue();
        return dishMapper.toDto(entities);
    }
}
