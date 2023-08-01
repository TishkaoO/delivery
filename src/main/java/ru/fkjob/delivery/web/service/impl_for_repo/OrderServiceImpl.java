package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.store.entity.OrderEntity;
import ru.fkjob.delivery.store.entity.StatusOrderEntity;
import ru.fkjob.delivery.store.repository.OrderRepository;
import ru.fkjob.delivery.web.dto.OrderDTO;
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

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            DishService dishService,
                            CustomerService customerService,
                            OrderBillingService orderBillingService) {
        this.orderRepository = orderRepository;
        this.dishService = dishService;
        this.customerService = customerService;
        this.orderBillingService = orderBillingService;
    }

    public OrderDTO create(long userId, List<Long> dishIds) {
        List<DishEntity> dishEntities = new ArrayList<>();
        for (Long id : dishIds) {
            DishEntity dishEntityById = dishService.getDishEntityById(id);
            dishEntities.add(dishEntityById);
        }
        BigDecimal totalAmount = orderBillingService.calculateTotalAmount(dishEntities);
        OrderEntity builder = OrderEntity.builder()
                .numberOfOrder(generateOrderNumber())
                .dishEntities(dishEntities)
                .created(Instant.now())
                .build();
        StatusOrderEntity statusEntity = builder.getStatusOrderEntity();
        statusEntity.setName("waiting for payment");
        OrderEntity saveOrder = orderRepository.save(builder);
        OrderDTO orderDto = OrderDTO.builder()
                .id(saveOrder.getId())
                .numberOfOrder(saveOrder.getNumberOfOrder())
                .created(saveOrder.getCreated())
                .nameOwner(saveOrder.getCustomerEntity().getUsername())
//                .dishDTOS(saveOrder.getDishEntities()) нужен мапер
                .statusName(saveOrder.getStatusOrderEntity().getName())
                .toPay(totalAmount)
                .build();
        //TODO: нужно сделать мапер чтобы так код не плодить
        CustomerEntity customer = customerService.getCustomerById(userId);
        List<OrderEntity> orderEntities = customer.getOrderEntityList();
        orderEntities.add(saveOrder);
        customer.setOrderEntityList(orderEntities);
//        customerService.save(customer);
        return orderDto;
    }
}
