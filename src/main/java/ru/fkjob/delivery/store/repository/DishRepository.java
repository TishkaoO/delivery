package ru.fkjob.delivery.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.fkjob.delivery.store.entity.DishEntity;

import java.util.List;

public interface DishRepository extends JpaRepository<DishEntity, Long> {

    @Query(value = "SELECT * FROM delivery.dish WHERE name ILIKE %:name%",
            nativeQuery = true)
    List<DishEntity> findDishEntitiesByName(@Param("name") String name);
}
