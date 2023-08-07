package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.web.dto.DishDTO;

public interface DishService {
    DishDTO getDishEntityById(long id);
}
