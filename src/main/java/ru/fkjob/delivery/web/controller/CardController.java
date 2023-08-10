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
import ru.fkjob.delivery.web.service.PaymentService;

@RestController
@Api(tags = "карта для оплаты")
public class CardController {
    private final CardService cardService;
    private final PaymentService paymentService;

    @Autowired
    public CardController(CardService cardService, PaymentService paymentService) {
        this.cardService = cardService;
        this.paymentService = paymentService;
    }

    @ApiOperation("зарегистрировать карту")
    @PostMapping("/create/card-customer/{customer_id}")
    public ResponseEntity<CardDTO> createCard(@PathVariable("customer_id") Long customerId, @RequestBody CardDTO dto) {
        CardDTO cardDTO = cardService.createCard(customerId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardDTO);
    }

    @ApiOperation("оплата дебетовой картой")
    @PostMapping("/pay-order/{orderId}/card/{cardId}")
    public ResponseEntity<Boolean> toPay(@PathVariable Long orderId, @PathVariable Long cardId) {
        boolean cardDTO = paymentService.toPay(orderId, cardId);
        return ResponseEntity.ok(cardDTO);
    }
}
