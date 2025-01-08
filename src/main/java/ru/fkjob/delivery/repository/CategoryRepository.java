package ru.fkjob.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.fkjob.delivery.domain.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Override
    @Query("SELECT c FROM CategoryEntity c LEFT JOIN FETCH c.dishes d LEFT JOIN FETCH d.image")
    List<CategoryEntity> findAll();
}
