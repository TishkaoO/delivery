package ru.fkjob.delivery.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CartDishRepository {

    private final JdbcTemplate jdbcTemplate;

    private final static String DELETE_CART_DISH = "DELETE FROM delivery.cart_dish WHERE cart_id = ? AND dish_id = ?";

    public int deleteCartDish(Long cartId, Long dishId) {
        return jdbcTemplate.update(DELETE_CART_DISH, cartId, dishId);
    }
}
