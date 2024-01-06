package ru.fkjob.delivery.rest.service;

import ru.fkjob.delivery.rest.dto.dish.DishDto;
import ru.fkjob.delivery.rest.dto.dish.DishInfoDto;

import java.util.List;

public interface DishService {
    DishInfoDto getDishEntityById(Long id);

    List<DishDto> getDishByName(String name);

    List<DishDto> getDishList();

    DishInfoDto save(Long categoryId, DishInfoDto dishInfoDto);

    Long updateDish(Long dishId, DishInfoDto dishInfoDto);

    void deleteDishEntityById(Long id);

}
