package ru.fkjob.delivery.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.web.dto.CustomerDTO;
import ru.fkjob.delivery.web.service.CustomerService;
import ru.fkjob.delivery.web.url.UrlContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = UrlContainer.REGISTRATION_USER)
    public ResponseEntity<CustomerDTO> createUser(@RequestBody CustomerDTO dto) {
        CustomerDTO save = customerService.save(dto);
        return ResponseEntity.ok(save);
    }
}
