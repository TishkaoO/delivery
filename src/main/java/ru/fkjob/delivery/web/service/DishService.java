package ru.fkjob.delivery.web.service;

import org.springframework.data.domain.Page;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.web.dto.DishDTO;

import java.util.List;

public interface DishService {
    DishEntity getDishEntityById(long id);

    DishDTO getDishByName(String name);

    Page<DishDTO> getDishByPage(int pageNo, int pageSize);
}
