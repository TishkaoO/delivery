package ru.fkjob.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
