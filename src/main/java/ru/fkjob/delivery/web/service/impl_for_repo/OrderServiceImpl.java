package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.store.entity.OrderEntity;
import ru.fkjob.delivery.store.entity.StatusOrderEntity;
import ru.fkjob.delivery.store.repository.OrderRepository;
import ru.fkjob.delivery.web.dto.CustomerDTO;
import ru.fkjob.delivery.web.dto.DishDTO;
import ru.fkjob.delivery.web.dto.OrderDTO;
import ru.fkjob.delivery.web.dto.mapper.CustomerMapper;
import ru.fkjob.delivery.web.dto.mapper.DishMapper;
import ru.fkjob.delivery.web.dto.mapper.OrderMapper;
import ru.fkjob.delivery.web.service.CustomerService;
import ru.fkjob.delivery.web.service.DishService;
import ru.fkjob.delivery.web.service.OrderBillingService;
import ru.fkjob.delivery.web.service.OrderService;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static ru.fkjob.delivery.web.utils.OrderNumberGenerator.generateOrderNumber;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final DishService dishService;
    private final CustomerService customerService;
    private final OrderBillingService orderBillingService;
    private final DishMapper dishMapper;
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, DishService dishService, 
                            CustomerService customerService, OrderBillingService orderBillingService, 
                            DishMapper dishMapper, OrderMapper orderMapper, CustomerMapper customerMapper) {
        this.orderRepository = orderRepository;
        this.dishService = dishService;
        this.customerService = customerService;
        this.orderBillingService = orderBillingService;
        this.dishMapper = dishMapper;
        this.orderMapper = orderMapper;
        this.customerMapper = customerMapper;
    }

    public OrderDTO create(long userId, List<Long> dishIds) {
        List<DishEntity> dishEntities = new ArrayList<>();
        for (Long id : dishIds) {
            DishDTO dishDTO = dishService.getDishEntityById(id);
            DishEntity entity = dishMapper.toEntity(dishDTO);
            dishEntities.add(entity);
        }
        StatusOrderEntity statusEntity = new StatusOrderEntity();
        statusEntity.setName("waiting for payment");
        OrderEntity builder = OrderEntity.builder()
                .numberOfOrder(generateOrderNumber())
                .dishEntities(dishEntities)
                .created(Instant.now())
                .statusOrderEntity(statusEntity)
                .build();
        OrderEntity saveOrder = orderRepository.save(builder);
        OrderDTO orderDto = orderMapper.toDto(saveOrder);
        CustomerDTO customerDTO = customerService.getCustomerById(userId);
        CustomerEntity entity = customerMapper.toEntity(customerDTO);
        List<OrderEntity> orderEntities = entity.getOrderEntityList();
        orderEntities.add(saveOrder);
        entity.setOrderEntityList(orderEntities);
        customerService.save(entity);
        return orderDto;
    }
}
