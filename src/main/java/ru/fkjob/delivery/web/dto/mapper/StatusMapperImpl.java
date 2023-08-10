package ru.fkjob.delivery.web.dto.mapper;

import org.springframework.stereotype.Component;
import ru.fkjob.delivery.store.entity.StatusOrderEntity;
import ru.fkjob.delivery.web.dto.StatusOrderDTO;

@Component
public class StatusMapperImpl implements StatusMapper {

    @Override
    public StatusOrderDTO toDto(StatusOrderEntity entity) {
        return StatusOrderDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public StatusOrderEntity toEntity(StatusOrderDTO dto) {
        return StatusOrderEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
