package ru.fkjob.delivery.web.dto.mapper;

import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.web.dto.CustomerDTO;

import java.util.List;

public interface CustomerMapper {

    CustomerDTO toDto(CustomerEntity entity);
    List<CustomerDTO> toDto(List<CustomerEntity> entity);
    CustomerEntity toEntity(CustomerDTO dto);
}
