package ru.fkjob.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.entity.ImageEntity;

public interface ImageFileRepository extends JpaRepository<ImageEntity, Long> {
}
