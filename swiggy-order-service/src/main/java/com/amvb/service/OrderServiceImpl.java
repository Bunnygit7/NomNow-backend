package com.amvb.service;

import com.amvb.DTOs.OrderDTO;
import com.amvb.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void createOrder(OrderDTO orderDto) {

    }

    @Override
    public List<OrderDTO> getOrdersByUserName(String userName) {
        return List.of();
    }
}
