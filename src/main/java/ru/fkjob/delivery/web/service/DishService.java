package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.store.entity.DishEntity;

public interface DishService {
    DishEntity getDishEntityById(long id);
}
