package com.amvb.service;

import com.amvb.DTOs.OrderDTO;
import com.amvb.entity.PaymentEntity;
import com.amvb.entity.PaymentStatus;
import com.amvb.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    @Override
    public void processPayment(OrderDTO orderDTO) {
        PaymentEntity paymentEntity=PaymentEntity.builder()
                .paymentStatus(PaymentStatus.PAYMENT_SUCCESS)
                .transactionId(orderDTO.getTransactionId())
                .userName(orderDTO.getUserName())
                .txnDateAndTime(LocalDateTime.now())
                .build();
        paymentRepository.save(paymentEntity);
        //Make a call to order service to create order

    }
}
