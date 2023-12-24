package ru.fkjob.delivery.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.web.dto.OrderDTO;
import ru.fkjob.delivery.web.service.OrderService;
import ru.fkjob.delivery.web.url.UrlContainer;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "заказ")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation("создать заказ")
    @PostMapping(path = UrlContainer.CREATE_ORDER)
    public ResponseEntity<OrderDTO> createOrder(@PathVariable long id, @RequestParam List<Long> dishIds) {
        return ResponseEntity.ok(orderService.create(id, dishIds));
    }
}
