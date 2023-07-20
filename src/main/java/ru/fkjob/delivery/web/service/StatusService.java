package ru.fkjob.delivery.web.service;

import ru.fkjob.delivery.store.entity.StatusOrderEntity;

public interface StatusService {

    StatusOrderEntity getStatusByName(String name);
}
