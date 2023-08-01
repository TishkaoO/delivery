package ru.fkjob.delivery.web.service.impl_for_repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.store.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerRepository repository;
    @InjectMocks
    private CustomerServiceImpl customerService;


    @Test
    void save() {

    }

    @Test
    void wheGetAll() {
        CustomerEntity customer1 = CustomerEntity.builder()
                .id(1l)
                .username("name")
                .build();
        CustomerEntity customer2 = CustomerEntity.builder()
                .id(2l)
                .username("name2")
                .build();
        List<CustomerEntity> customerEntities = List.of(customer1, customer2);
        Mockito.when(repository.findAll()).thenReturn(customerEntities);
        List<CustomerEntity> result = customerService.getAll();
        Assertions.assertEquals(customerEntities.size(), result.size());
    }

    @Test
    void wheGetAllAndNotFound() {
        List<CustomerEntity> customerEntities = List.of();
        Mockito.when(repository.findAll()).thenReturn(customerEntities);
        List<CustomerEntity> result = customerService.getAll();
        Assertions.assertEquals(customerEntities.size(), result.size());
    }

    @Test
    void getCustomerById() {
        CustomerEntity customer1 = CustomerEntity.builder()
                .id(1l)
                .username("name")
                .build();
        Mockito.when(repository.findById(1l)).thenReturn(Optional.of(customer1));
        CustomerEntity custocustomerByIdmerById = customerService.getCustomerById(1l);
        Assertions.assertEquals(customer1, custocustomerByIdmerById);
    }

    @Test
    void whenCustomerGetById() {
        CustomerEntity customer1 = CustomerEntity.builder()
                .id(1l)
                .username("name")
                .build();
        CustomerEntity customer2 = CustomerEntity.builder()
                .id(2l)
                .username("name")
                .build();
        Mockito.when(repository.findById(1l)).thenReturn(Optional.of(customer1));
        CustomerEntity custocustomerByIdmerById = customerService.getCustomerById(1l);
        Assertions.assertEquals(customer1, custocustomerByIdmerById);
        Assertions.assertNotEquals(customer1, customer2);
    }

    @Test
    void whenCustomerGetByIdAndException() {
        Mockito.when(repository.findById(1l)).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> customerService.getCustomerById(1l));
    }

    @Test
    void updateCustomer() {
    }
}