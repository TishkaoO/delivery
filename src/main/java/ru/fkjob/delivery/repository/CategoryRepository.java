package ru.fkjob.delivery.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.fkjob.delivery.domain.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"dishes", "dishes.image"})
    // внесла изменения. Добавила @EntityGraph и подгрузила сущности "dishes", "dishes.image"
    List<CategoryEntity> findAll();
}
