package com.amvb.service;

import com.amvb.DTOs.OrderDTO;

import java.util.Map;

public interface PaymentService {
    void processPayment(OrderDTO orderDTO);
    Map<String, Object> createOrder(Map<String, Object> data);
    String verifyPayment(Map<String, String> data);
}
