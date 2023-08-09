package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.store.repository.DishRepository;
import ru.fkjob.delivery.web.dto.DishDTO;
import ru.fkjob.delivery.web.dto.mapper.DishMapper;
import ru.fkjob.delivery.web.service.DishService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, @Qualifier("dishMapperImpl") DishMapper dishMapper) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
    }

    @Override
    public DishEntity getDishEntityById(long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    @Override
    public DishDTO getDishByName(String name) {
        return dishRepository.findDishEntitiesByName(name)
                .map(entity -> dishMapper.toDto(entity))
                .orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    @Override
    public Page<DishDTO> getDishByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<DishEntity> all = dishRepository.findAll(pageable);
        return all.map(dishMapper::toDto);
    }
}
