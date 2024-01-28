package ru.fkjob.delivery.service;


import ru.fkjob.delivery.dto.dish.DishDto;
import ru.fkjob.delivery.dto.dish.DishItemDto;
import ru.fkjob.delivery.dto.order.OrderItemDto;

import java.util.List;

public interface OrderService {

    OrderItemDto createOrder(List<DishItemDto> dishes);
}
