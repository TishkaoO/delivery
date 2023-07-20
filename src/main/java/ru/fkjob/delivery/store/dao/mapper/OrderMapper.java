package ru.fkjob.delivery.store.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.fkjob.delivery.web.dto.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderDTO> {
    private final String ORDER_ID = "order_id";
    private final String NUMBER_OF_ORDER = "number_of_order";
    private final String CREATE_DATE = "created_date";
    private final String NAME_OWNER = "fk_order_id";
    private final String DISH = "";
    private final String STATUS_NAME = "";

    @Override
    public OrderDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(rs.getLong(ORDER_ID));
        String customer = rs.getString(NAME_OWNER);
        return null;

    }
}
