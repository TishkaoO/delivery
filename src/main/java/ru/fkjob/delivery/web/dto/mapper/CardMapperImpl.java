package ru.fkjob.delivery.web.dto.mapper;

import org.springframework.stereotype.Component;
import ru.fkjob.delivery.store.entity.CardEntity;
import ru.fkjob.delivery.web.dto.CardDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapperImpl implements CardMapper {

    @Override
    public CardDTO toDto(CardEntity entity) {
        return CardDTO.builder()
                .id(entity.getId())
                .nameOwner(entity.getNameOwner())
                .cardNumber(entity.getCardNumber())
                .expiryDate(entity.getExpiryDate())
                .cvv(entity.getCvv())
                .balance(entity.getBalance())
                .build();
    }

    @Override
    public List<CardDTO> toDto(List<CardEntity> entity) {
        return entity.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardEntity toEntity(CardDTO dto) {
        return CardEntity.builder()
                .id(dto.getId())
                .nameOwner(dto.getNameOwner())
                .cardNumber(dto.getCardNumber())
                .expiryDate(dto.getExpiryDate())
                .cvv(dto.getCvv())
                .balance(dto.getBalance())
                .build();
    }
}
