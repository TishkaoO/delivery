package ru.fkjob.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.fkjob.delivery.domain.CartEntity;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    Optional<CartEntity> findByUserId(Long userId);

    @Query(value = "select count(dish_id) from delivery.cart_dish where dish_id = :dishId", nativeQuery = true)
    Integer findCountDishFromCartByDishId(@Param("dishId") Long dishId);
}
