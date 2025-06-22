package com.amvb.broker;

import com.amvb.DTOs.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "nomnow-order-service")
public interface OrderBroker {

    @PostMapping("/orders")
    String createOrder(OrderDTO orderDTO);
}
