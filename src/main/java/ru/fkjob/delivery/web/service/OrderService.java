package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.web.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO create(long userId, List<Long> dishIds);
}
