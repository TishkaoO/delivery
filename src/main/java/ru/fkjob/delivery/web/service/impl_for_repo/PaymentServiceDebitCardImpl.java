package ru.fkjob.delivery.web.service.impl_for_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fkjob.delivery.store.entity.CardEntity;
import ru.fkjob.delivery.store.entity.OrderEntity;
import ru.fkjob.delivery.store.entity.StatusOrderEntity;
import ru.fkjob.delivery.store.repository.CardRepository;
import ru.fkjob.delivery.store.repository.CustomerRepository;
import ru.fkjob.delivery.store.repository.OrderRepository;
import ru.fkjob.delivery.store.repository.StatusRepository;
import ru.fkjob.delivery.web.dto.mapper.OrderMapper;
import ru.fkjob.delivery.web.exception.PaymentException;
import ru.fkjob.delivery.web.service.PaymentService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class PaymentServiceDebitCardImpl implements PaymentService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;
    private final StatusRepository statusRepository;
    private final CardRepository cardRepository;

    @Autowired
    public PaymentServiceDebitCardImpl(OrderRepository orderRepository, CardRepository cardRepository,
                                       OrderMapper orderMapper, CustomerRepository customerRepository,
                                       StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.cardRepository = cardRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.statusRepository = statusRepository;
    }

    @Transactional
    public boolean toPay(long orderId, long cardId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("order not found"));
        CardEntity card = cardRepository.findById(cardId)
                .orElseThrow(() -> new NoSuchElementException("card not found"));
        StatusOrderEntity statusOrder = statusRepository.findByName("заказ готовится")
                .orElseThrow(() -> new NoSuchElementException("status not found"));
        BigDecimal debit;
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (card.getExpiryDate().isBefore(currentDateTime)) {
            throw new PaymentException("The card has expired.");
        }
        BigDecimal price = order.getPrice();
        BigDecimal balance = card.getBalance();
        if (price.compareTo(balance) <= 0) {
            debit = balance.subtract(price);
            card.setBalance(debit);
            cardRepository.save(card);
            order.setStatusOrderEntity(statusOrder);
            orderRepository.save(order);
            return true;
        }
        return false;
    }
}
