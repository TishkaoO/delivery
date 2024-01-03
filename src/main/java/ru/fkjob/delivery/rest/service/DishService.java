package ru.fkjob.delivery.rest.service;

import ru.fkjob.delivery.rest.dto.dish.DishDto;
import ru.fkjob.delivery.rest.dto.dish.DishInfoDto;

import java.util.List;

public interface DishService {
    DishInfoDto getDishEntityById(long id);

    List<DishDto> getDishByName(String name);

    List<DishDto> getDishList();

    DishInfoDto save(Long categoryId, DishInfoDto dishInfoDto);

    Long updateDish(long dishId, DishInfoDto dishInfoDto);

    void deleteDishEntityById(long id);

}
