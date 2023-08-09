package ru.fkjob.delivery.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fkjob.delivery.web.dto.CardDTO;
import ru.fkjob.delivery.web.service.CardService;

@RestController
@Api(tags = "карта для оплаты")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @ApiOperation("зарегистрировать карту")
    @PostMapping("/create/card-customer/{customer_id}")
    public ResponseEntity<CardDTO> createCard(@PathVariable("customer_id") Long customerId, @RequestBody CardDTO dto) {
        CardDTO cardDTO = cardService.createCard(customerId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardDTO);
    }
}
