package ru.fkjob.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.dto.cart.CartDto;
import ru.fkjob.delivery.dto.dish.DishDto;
import ru.fkjob.delivery.dto.dish.DishItemDto;
import ru.fkjob.delivery.dto.order.OrderItemDto;
import ru.fkjob.delivery.service.OrderService;

import java.util.ArrayList;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderItemDto createOrder(List<DishItemDto> dishes) {
        OrderItemDto order = new OrderItemDto();
        if (dishes == null || dishes.isEmpty()) {
            order.setSuccess(false);
            return order;
        }
        order.setSuccess(true);
        CartDto cart = new CartDto();
        List<DishItemDto> cartItems = new ArrayList<>();
        for (DishItemDto dish : dishes) {
            DishItemDto dishItem = new DishItemDto();
            dishItem.setId(dish.getId());
            dishItem.setCount(dish.getCount());
            cartItems.add(dishItem);
        }
        cart.setCartItems(cartItems);
        order.setCart(cart);
        return order;
    }

}
