package ru.fkjob.delivery.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.web.dto.CustomerDTO;
import ru.fkjob.delivery.web.service.CustomerService;
import ru.fkjob.delivery.web.url.UrlContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

@CrossOrigin

@RestController
@Api(tags = "покупатель")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation("регистрация пользователя")
    @PostMapping(path = UrlContainer.REGISTRATION_USER)
    public ResponseEntity<CustomerDTO> createUser(@RequestBody CustomerDTO dto) {
        CustomerDTO save = customerService.save(dto);
        return ResponseEntity.ok(save);
    }
}
