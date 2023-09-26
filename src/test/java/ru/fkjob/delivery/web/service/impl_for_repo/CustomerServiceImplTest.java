package ru.fkjob.delivery.web.service.impl_for_repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.fkjob.delivery.config.TestConfig;
import ru.fkjob.delivery.store.entity.CustomerEntity;
import ru.fkjob.delivery.store.repository.CustomerRepository;

@SpringBootTest(classes = TestConfig.class)
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {
    @Autowired
    private CustomerServiceImpl customerService;

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
        CustomerEntity actual = customerService.save(customerEntity);
        Assertions.assertEquals(expected, actual);
    }
}