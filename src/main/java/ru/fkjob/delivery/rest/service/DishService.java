package ru.fkjob.delivery.rest.service;

import org.springframework.data.domain.Page;
import ru.fkjob.delivery.rest.dto.DishDto;
import ru.fkjob.delivery.store.entity.DishEntity;

public interface DishService {
    DishEntity getDishEntityById(long id);

    DishDto getDishByName(String name);

    Page<DishDto> getDishByPage(int pageNo, int pageSize);
}
