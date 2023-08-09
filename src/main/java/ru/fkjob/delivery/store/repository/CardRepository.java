package ru.fkjob.delivery.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.store.entity.CardEntity;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
