package com.amvb.service;


import com.amvb.DTOs.OrderDTO;

import java.util.List;

public interface OrderService {
    void createOrder(OrderDTO orderDto);
    List<OrderDTO> getOrdersByUserName(String userName);
}
