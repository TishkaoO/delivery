package ru.fkjob.delivery.web.dto.mapper;

import ru.fkjob.delivery.store.entity.CardEntity;
import ru.fkjob.delivery.web.dto.CardDTO;

import java.util.List;

public interface CardMapper {

    CardDTO toDto(CardEntity entity);

    List<CardDTO> toDto(List<CardEntity> entity);

    CardEntity toEntity(CardDTO dto);
}
