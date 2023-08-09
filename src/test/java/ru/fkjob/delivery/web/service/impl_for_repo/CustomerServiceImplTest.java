package ru.fkjob.delivery.web.service.impl_for_repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.fkjob.delivery.config.TestConfig;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.store.repository.CustomerRepository;
import ru.fkjob.delivery.web.dto.CustomerDTO;

@SpringBootTest(classes = TestConfig.class)
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void createTest() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .username("Semen34")
                .password("12345678")
                .email("kek@gmail.com")
                .build();
        CustomerEntity expected = CustomerEntity.builder()
                .id(1l)
                .username("Semen34")
                .password("12345678")
                .email("kek@gmail.com")
                .build();
        customerRepository.deleteAll();
        CustomerEntity actual = customerService.save(customerEntity);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getCustomerByIdTest() {
        CustomerDTO expected = CustomerDTO.builder()
                .id(1l)
                .username("Alex123")
                .password("12345678")
                .email("lol@gmail.com")
                .build();
        CustomerDTO actual = customerService.getCustomerById(1l);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateCustomerTest() {
        CustomerDTO expected = CustomerDTO.builder()
                .id(1l)
                .username("Alex123")
                .password("1234567811")
                .email("lolbugaga@gmail.com")
                .build();
        CustomerDTO actual = customerService.updateCustomer(1l, expected);
        Assertions.assertEquals(expected, actual);
    }
}