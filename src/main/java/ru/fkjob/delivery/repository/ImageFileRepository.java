package ru.fkjob.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.entity.DishEntity;
import ru.fkjob.delivery.entity.ImageEntity;

import java.util.Optional;

public interface ImageFileRepository extends JpaRepository<ImageEntity, Long> {

    Optional<ImageEntity> findFirstByDish(DishEntity dish);
}
