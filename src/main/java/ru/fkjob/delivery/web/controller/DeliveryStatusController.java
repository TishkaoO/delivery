package ru.fkjob.delivery.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.web.dto.StatusOrderDTO;
import ru.fkjob.delivery.web.service.StatusService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Api(tags = "статус заказа")
public class DeliveryStatusController {
    private final StatusService statusService;

    @Autowired
    public DeliveryStatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @ApiOperation("получить статус заказа")
    @GetMapping("/check-status/order/{orderId}")
    public ResponseEntity<StatusOrderDTO> createUser(@PathVariable Long orderId) {
        StatusOrderDTO statusByOrderId = statusService.getStatusByOrderId(orderId);
        return ResponseEntity.ok(statusByOrderId);
    }
}
