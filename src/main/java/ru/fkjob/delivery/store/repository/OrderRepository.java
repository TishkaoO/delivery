package ru.fkjob.delivery.store.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.store.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
