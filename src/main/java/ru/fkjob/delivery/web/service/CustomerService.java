package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.web.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO save(CustomerDTO customer);

    CustomerDTO getCustomerById(long id);

    CustomerDTO updateCustomer(long id, CustomerDTO customerDTO);

    List<CustomerDTO> getAll();

    CustomerEntity save(CustomerEntity customer);
}
