package com.amvb.service;

import com.amvb.DTOs.OrderDTO;
import com.amvb.entity.PaymentEntity;

public interface PaymentService {
    void processPayment(OrderDTO orderDTO);
}
