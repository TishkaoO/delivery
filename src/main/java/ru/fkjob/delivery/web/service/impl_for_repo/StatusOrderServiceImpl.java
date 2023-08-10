package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.store.entity.OrderEntity;
import ru.fkjob.delivery.store.entity.StatusOrderEntity;
import ru.fkjob.delivery.store.repository.OrderRepository;
import ru.fkjob.delivery.store.repository.StatusRepository;
import ru.fkjob.delivery.web.dto.StatusOrderDTO;
import ru.fkjob.delivery.web.dto.mapper.StatusMapper;
import ru.fkjob.delivery.web.service.StatusService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StatusOrderServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    private final OrderRepository orderRepository;
    private final StatusMapper statusMapper;

    @Autowired
    public StatusOrderServiceImpl(StatusRepository statusRepository, OrderRepository orderRepository,
                                  StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.orderRepository = orderRepository;
        this.statusMapper = statusMapper;
    }

    @Override
    public StatusOrderEntity getStatusByName(String name) {
        return null;
    }

    @Override
    public StatusOrderDTO getStatusByOrderId(long orderId) {
     OrderEntity orderEntity = orderRepository.findById(orderId)
             .orElseThrow(() -> new NoSuchElementException("order not found"));
        StatusOrderEntity statusOrderEntity = orderEntity.getStatusOrderEntity();
        return statusMapper.toDto(statusOrderEntity);
    }
}
