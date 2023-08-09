package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.web.dto.CardDTO;

public interface CardService {

    CardDTO createCard(long userId, CardDTO dto);
}
