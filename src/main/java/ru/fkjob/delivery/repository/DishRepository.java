package ru.fkjob.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.fkjob.delivery.domain.DishEntity;

import java.util.List;

public interface DishRepository extends JpaRepository<DishEntity, Long> {

    @Query(value = "SELECT * FROM delivery.dish WHERE name ILIKE :name% order by name LIMIT 10",
            nativeQuery = true)
    List<DishEntity> findDishEntitiesByNameStartWithName(@Param("name") String name);

    @Query(value = "SELECT * FROM delivery.dish WHERE name ILIKE %:name% order by name LIMIT 10",
            nativeQuery = true)
    List<DishEntity> findDishEntitiesByName(@Param("name") String name);

    @Query(value = "SELECT * FROM delivery.dish WHERE is_stock = true",
            nativeQuery = true)
    List<DishEntity> findDishEntitiesByStockIsTrue();
}
