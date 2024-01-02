package ru.fkjob.delivery.rest.service;

import org.springframework.data.domain.Page;
import ru.fkjob.delivery.rest.dto.dish.DishDto;
import ru.fkjob.delivery.rest.dto.dish.DishInfoDto;

import java.util.List;

public interface DishService {
    DishInfoDto getDishEntityById(long id);

    List<DishDto> getDishByName(String name);

    Page<DishDto> getDishByPage(int pageNo, int pageSize);

    DishInfoDto save(DishInfoDto dishInfoDto);

    Long updateDish(long dishId, DishInfoDto dishInfoDto);

    void deleteDishEntityById(long id);
}
