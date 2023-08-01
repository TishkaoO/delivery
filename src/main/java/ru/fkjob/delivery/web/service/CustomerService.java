package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.web.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO save(CustomerDTO customer);

    CustomerEntity getCustomerById(long id);

    CustomerEntity updateCustomer(long id, CustomerDTO customerDTO);

    List<CustomerEntity> getAll();
}
