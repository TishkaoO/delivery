package ru.fkjob.delivery.store.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.fkjob.delivery.web.dto.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<CustomerDTO> {
    private final String CUSTOMER_ID = "customer_id";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";

    @Override
    public CustomerDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(rs.getLong(CUSTOMER_ID));
        customerDTO.setUsername(rs.getString(USERNAME));
        customerDTO.setPassword(rs.getString(PASSWORD));
        return customerDTO;
    }
}
