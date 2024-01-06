package ru.fkjob.delivery.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.store.entity.ImageEntity;

public interface ImageFileRepository extends JpaRepository<ImageEntity, Long> {
}
