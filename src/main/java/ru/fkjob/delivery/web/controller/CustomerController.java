package ru.fkjob.delivery.web.controller;

import ru.fkjob.delivery.web.dto.CustomerDTO;
import ru.fkjob.delivery.web.service.CustomerService;
import ru.fkjob.delivery.web.url.UrlContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fkjob.delivery.store.entity.CustomerEntity;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = UrlContainer.REGISTRATION_USER)
    public ResponseEntity<CustomerDTO> createUser(@RequestBody CustomerEntity customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }
}
