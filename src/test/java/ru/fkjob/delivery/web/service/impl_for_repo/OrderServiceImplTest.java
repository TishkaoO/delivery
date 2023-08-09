package ru.fkjob.delivery.web.service.impl_for_repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.fkjob.delivery.config.TestConfig;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.web.dto.DishDTO;
import ru.fkjob.delivery.web.dto.OrderDTO;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestConfig.class)
@ExtendWith(SpringExtension.class)
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void createOrderTest() {
        List<Long> dishIds = List.of(1l, 3l);
        Long userId = 1l;
        String status = "ожидает оплаты";
        List<DishDTO> dishDTOS = List.of(DishDTO.builder()
                .id(1l)
                .name("паста")
                .price(BigDecimal.valueOf(10))
                .build(),
                DishDTO.builder()
                        .id(3l)
                        .name("борщ")
                        .price(BigDecimal.valueOf(8))
                        .build()
                );
        OrderDTO orderDTO = orderService.create(userId, dishIds);
        List<DishDTO> actualDishDtos = orderDTO.getDishDTOS();
        Assertions.assertEquals(dishDTOS.size(), actualDishDtos.size());
        Assertions.assertEquals(status, orderDTO.getStatusName());
    }
}