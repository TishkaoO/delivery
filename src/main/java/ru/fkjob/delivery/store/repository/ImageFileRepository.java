package ru.fkjob.delivery.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.fkjob.delivery.store.entity.DishEntity;
import ru.fkjob.delivery.store.entity.ImageEntity;

import java.util.List;

public interface ImageFileRepository extends JpaRepository<ImageEntity, Long> {

    @Query(value = "DELETE FROM delivery.image WHERE pk_image_id = :id" , nativeQuery = true)
    void deleteImageById(@Param("id") Long id);
}
