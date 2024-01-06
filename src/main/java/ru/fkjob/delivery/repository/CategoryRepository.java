package ru.fkjob.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
