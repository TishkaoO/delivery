package ru.fkjob.delivery.service;


import ru.fkjob.delivery.dto.cart.CartDto;
import ru.fkjob.delivery.dto.cart.CartDishInfoDto;
import ru.fkjob.delivery.dto.dish.DishItemDto;

import java.util.List;

public interface CartService {

    CartDto createCart(List<DishItemDto> dish);
    List<CartDishInfoDto> getSummary();
}
