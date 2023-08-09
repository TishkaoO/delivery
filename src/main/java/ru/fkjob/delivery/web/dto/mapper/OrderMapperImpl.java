package ru.fkjob.delivery.web.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.store.entity.OrderEntity;
import ru.fkjob.delivery.web.dto.DishDTO;
import ru.fkjob.delivery.web.dto.OrderDTO;
import ru.fkjob.delivery.web.service.OrderBillingService;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperImpl implements OrderMapper {
    private final DishMapper dishMapper;
    private final OrderBillingService orderBillingService;

    @Autowired
    public OrderMapperImpl(DishMapper dishMapper, OrderBillingService orderBillingService) {
        this.dishMapper = dishMapper;
        this.orderBillingService = orderBillingService;
    }

    @Override
    public OrderDTO toDto(OrderEntity entity) {
        List<DishEntity> dishEntities = entity.getDishEntities();
        List<DishDTO> dishDTOS = dishMapper.toDto(dishEntities);
        return OrderDTO.builder()
                .id(entity.getId())
                .numberOfOrder(entity.getNumberOfOrder())
                .created(entity.getCreated())
                .dishDTOS(dishDTOS)
                .statusName(entity.getStatusOrderEntity().getName())
                .toPay(orderBillingService.calculateTotalAmount(dishEntities))
                .build();
    }

    @Override
    public List<OrderDTO> toDto(List<OrderEntity> entity) {
        return null;
    }

    @Override
    public OrderEntity toEntity(OrderDTO dto) {
        return null;
    }
}
