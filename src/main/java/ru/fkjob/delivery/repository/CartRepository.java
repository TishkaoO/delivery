package ru.fkjob.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.domain.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
