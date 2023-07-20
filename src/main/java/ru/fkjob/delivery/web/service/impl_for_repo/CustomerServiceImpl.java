package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.store.repository.CustomerRepository;
import ru.fkjob.delivery.web.dto.CustomerDTO;
import ru.fkjob.delivery.web.service.CustomerService;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO save(CustomerEntity customer) {
        if (!isValidUser(customer)) {
            throw new IllegalArgumentException("Invalid user data");
        }
        CustomerEntity customerEntity = CustomerEntity.builder()
                .username(customer.getUsername())
                .password(customer.getPassword())
                .build();
        CustomerEntity entity = customerRepository.save(customerEntity);
        return CustomerDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public CustomerEntity getCustomerById(long id) {
        return null;
    }

    private boolean isValidUser(CustomerEntity customer) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findByUsername(customer.getUsername());
        if (!customerEntityOptional.isEmpty()) {
            throw new IllegalArgumentException("username is exists");
        }
        if (customer.getUsername() == null || customer.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Login cannot be empty");
        }
        if (!customer.getUsername().matches("[A-Za-z0-9\\s-]+")) {
            throw new IllegalArgumentException("Name contains invalid characters");
        }
        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if (customer.getPassword().length() < 5 || customer.getPassword().length() > 15) {
            throw new IllegalArgumentException("Password length must be between 5 and 15 characters");
        }
        return true;
    }
}
