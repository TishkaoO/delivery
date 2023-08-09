package ru.fkjob.delivery.web.dto.mapper;

import ru.fkjob.delivery.store.entity.OrderEntity;
import ru.fkjob.delivery.web.dto.OrderDTO;

import java.util.List;

public interface OrderMapper {
    OrderDTO toDto(OrderEntity entity);
    List<OrderDTO> toDto(List<OrderEntity> entity);
    OrderEntity toEntity(OrderDTO dto);
}
