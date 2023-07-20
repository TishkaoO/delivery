package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.web.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO save(CustomerEntity customer);

    CustomerEntity getCustomerById(long id);
}
