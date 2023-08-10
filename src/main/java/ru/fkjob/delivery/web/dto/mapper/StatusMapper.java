package ru.fkjob.delivery.web.dto.mapper;

import ru.fkjob.delivery.store.entity.StatusOrderEntity;
import ru.fkjob.delivery.web.dto.StatusOrderDTO;

public interface StatusMapper {

    StatusOrderDTO toDto(StatusOrderEntity entity);

    StatusOrderEntity toEntity(StatusOrderDTO dto);
}
