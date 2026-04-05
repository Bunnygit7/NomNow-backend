package com.amvb.service;

import com.amvb.DTOs.OrderDTO;
import com.amvb.repository.OrderRepository;
import com.amvb.utils.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Override
    public void createOrder(OrderDTO orderDto) {
        orderRepository.save(orderMapper.dtoToEntity(orderDto));
    }

    @Override
    public List<OrderDTO> getOrdersByUserName(String userName) {
        return orderMapper.entityListToDtoList(orderRepository.findByUserName(userName).orElse(null));
    }
}
