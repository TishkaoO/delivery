package ru.fkjob.delivery.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.store.entity.DishEntity;

import java.util.Optional;

public interface DishRepository extends JpaRepository<DishEntity, Long> {

    Optional<DishEntity> findDishEntitiesByName(String name);
}
