package ru.fkjob.delivery.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.store.entity.StatusOrderEntity;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<StatusOrderEntity, Long> {

    Optional<StatusOrderEntity> findByName(String name);
}
