package ru.fkjob.delivery.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@TestConfiguration
public class TestConfig {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public PostgreSQLContainer<?> postgreSQLContainer() {
        return new PostgreSQLContainer<>("postgres:15");
    }

    @Bean
    public DataSource datasource(PostgreSQLContainer<?> postgreSQLContainer) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(postgreSQLContainer.getJdbcUrl());
        hikariDataSource.setUsername(postgreSQLContainer.getUsername());
        hikariDataSource.setPassword(postgreSQLContainer.getPassword());
        return hikariDataSource;
    }
}
