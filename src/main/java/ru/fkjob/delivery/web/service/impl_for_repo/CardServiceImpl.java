package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.CardEntity;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.store.repository.CardRepository;
import ru.fkjob.delivery.store.repository.CustomerRepository;
import ru.fkjob.delivery.web.dto.CardDTO;
import ru.fkjob.delivery.web.dto.mapper.CardMapper;
import ru.fkjob.delivery.web.service.CardService;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;
    private final CardMapper cardMapper;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, CustomerRepository customerRepository,
                           CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.customerRepository = customerRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public CardDTO createCard(long userId, CardDTO dto) {
        CardEntity cardEntity = CardEntity.builder()
                .nameOwner(dto.getNameOwner())
                .cardNumber(dto.getCvv())
                .expiryDate(dto.getExpiryDate())
                .balance(BigDecimal.valueOf(100))
                .cvv(dto.getCvv())
                .build();
        CardEntity save = cardRepository.save(cardEntity);
        CustomerEntity customerEntity = customerRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("not found"));
        customerEntity.setCardEntities(Set.of(save));
        return cardMapper.toDto(cardEntity);
    }
}
