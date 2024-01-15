package ru.fkjob.delivery.service;

import ru.fkjob.delivery.dto.dish.DishDto;
import ru.fkjob.delivery.dto.dish.DishInfoDto;

import java.util.List;

public interface DishService {
    DishInfoDto getDishEntityById(Long id);

    List<DishDto> getDishByName(String name);

    List<DishDto> getDishList();

    DishInfoDto save(DishInfoDto dishInfoDto, Long categoryId);

    Long updateDish(Long dishId, DishInfoDto dishInfoDto);

    void deleteDishEntityById(Long id);

    List<DishDto> getDishByIsStock();

}
