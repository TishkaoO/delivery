package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.StatusOrderEntity;
import ru.fkjob.delivery.web.service.StatusService;

@Service
public class StatusOrderServiceImpl implements StatusService {

    @Override
    public StatusOrderEntity getStatusByName(String name) {
        return null;
    }
}
