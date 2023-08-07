package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.store.repository.CustomerRepository;
import ru.fkjob.delivery.web.dto.CustomerDTO;
import ru.fkjob.delivery.web.dto.mapper.DishMapper;
import ru.fkjob.delivery.web.service.CustomerService;
import ru.fkjob.delivery.web.service.mail.CustomerEventPublisher;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerEventPublisher customerEventPublisher;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerEventPublisher customerEventPublisher) {
        this.customerRepository = customerRepository;
        this.customerEventPublisher = customerEventPublisher;
    }

    @Override
    public CustomerDTO save(CustomerDTO customer) {
        if (!isValidUser(customer)) {
            throw new IllegalArgumentException("Invalid user data");
        }
        CustomerEntity customerEntity = CustomerEntity.builder()
                .email(customer.getEmail())
                .username(customer.getUsername())
                .password(customer.getPassword())
                .build();
        CustomerEntity entity = customerRepository.save(customerEntity);
        customerEventPublisher.publishCustomerRegisteredEvent(entity);
        return CustomerDTO.builder()
                .id(entity.getId())
                .email(customer.getEmail())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public List<CustomerEntity> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public CustomerEntity updateCustomer(long id, CustomerDTO customerDTO) {
        CustomerEntity entity = customerRepository.findById(id).orElseThrow(() -> new RuntimeException());
        entity.setUsername("username1234");
        return customerRepository.save(entity);
    }

    private boolean isValidUser(CustomerDTO dto) {
        CustomerEntity customer = CustomerEntity.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
//        Optional<CustomerEntity> customerEntityOptional = customerRepository.findByUsername(customer.getUsername());
//        if (!customerEntityOptional.isEmpty()) {
//            throw new IllegalArgumentException("username is exists");
//        }
        if (dto.getUsername() == null || dto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Login cannot be empty");
        }
        if (!dto.getUsername().matches("[A-Za-z0-9\\s-]+")) {
            throw new IllegalArgumentException("Name contains invalid characters");
        }
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if (dto.getPassword().length() < 5 || dto.getPassword().length() > 15) {
            throw new IllegalArgumentException("Password length must be between 5 and 15 characters");
        }
        return true;
    }
}
