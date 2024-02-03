package ru.fkjob.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.dto.cart.CartDto;
import ru.fkjob.delivery.dto.cart.CartItemDto;
import ru.fkjob.delivery.dto.cart.CartDishInfoDto;
import ru.fkjob.delivery.dto.dish.DishItemDto;
import ru.fkjob.delivery.service.CartService;

import java.util.ArrayList;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    @Override
    public CartDto createCart(List<DishItemDto> dishes) {
        CartDto cart = new CartDto();
        if (dishes == null || dishes.isEmpty()) {
            cart.setSuccess(false);
            return cart;
        }
        cart.setSuccess(true);
        CartItemDto cartItem = new CartItemDto();
        List<DishItemDto> cartItems = new ArrayList<>();
        dishes.stream()
                .map(dish -> new DishItemDto(dish.getId(), dish.getCount()))
                .forEach(cartItems::add);
        cartItem.setCartItems(cartItems);
        cart.setCart(cartItem);
        return cart;
    }

    @Override
    public List<CartDishInfoDto> getCartInfos() {
        return null;
    }

}
