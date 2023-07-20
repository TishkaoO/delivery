package ru.fkjob.delivery.web.service;

import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.DishEntity;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderBillingService {
    public BigDecimal calculateTotalAmount(List<DishEntity> dishEntities) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (DishEntity dish : dishEntities) {
            totalAmount = totalAmount.add(dish.getPrice());
        }
        return totalAmount;
    }
}
