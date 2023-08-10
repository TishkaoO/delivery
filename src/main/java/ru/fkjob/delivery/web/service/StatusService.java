package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.store.entity.StatusOrderEntity;
import ru.fkjob.delivery.web.dto.StatusOrderDTO;

public interface StatusService {

    StatusOrderEntity getStatusByName(String name);

    StatusOrderDTO getStatusByOrderId(long orderId);
}
