package com.amvb.broker;

import com.amvb.DTOs.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "swiggy-order-service")
public interface OrderBroker {

    @PostMapping("/orders")
    public String createOrder(OrderDTO orderDTO);
}
