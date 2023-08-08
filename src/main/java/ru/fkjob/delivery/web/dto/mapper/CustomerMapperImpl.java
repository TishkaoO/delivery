package ru.fkjob.delivery.web.dto.mapper;

import org.springframework.stereotype.Component;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.web.dto.CustomerDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDto(CustomerEntity entity) {
        return CustomerDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public List<CustomerDTO> toDto(List<CustomerEntity> entity) {
        return entity.stream()
                .map(customerEntity -> toDto(customerEntity))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerEntity toEntity(CustomerDTO dto) {
        return CustomerEntity.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}
