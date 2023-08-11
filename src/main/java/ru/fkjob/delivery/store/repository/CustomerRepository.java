package ru.fkjob.delivery.store.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ru.fkjob.delivery.store.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByUsername(String username);
}
