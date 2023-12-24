package ru.fkjob.delivery.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.rest.dto.DishDto;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.store.repository.DishRepository;
import ru.fkjob.delivery.rest.dto.mapper.DishMapper;
import ru.fkjob.delivery.rest.service.DishService;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Override
    public DishEntity getDishEntityById(long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    @Override
    public DishDto getDishByName(String name) {
        return dishRepository.findDishEntitiesByName(name)
                .map(entity -> dishMapper.toDto(entity))
                .orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    @Override
    public Page<DishDto> getDishByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<DishEntity> all = dishRepository.findAll(pageable);
        return all.map(dishMapper::toDto);
    }
}
