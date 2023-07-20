package ru.fkjob.delivery.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.web.dto.OrderDTO;
import ru.fkjob.delivery.web.service.OrderService;
import ru.fkjob.delivery.web.url.UrlContainer;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = UrlContainer.CREATE_ORDER)
    public ResponseEntity<OrderDTO> createOrder(@PathVariable long id, @RequestParam List<Long> dishIds) {
        return ResponseEntity.ok(orderService.create(id, dishIds));
    }
}
