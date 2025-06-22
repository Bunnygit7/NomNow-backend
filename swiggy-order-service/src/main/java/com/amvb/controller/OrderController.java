package com.amvb.controller;

import com.amvb.DTOs.OrderDTO;
import com.amvb.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    final OrderService orderService;

    @PostMapping
    public String createOrder(@RequestBody OrderDTO orderDto) {
        orderService.createOrder(orderDto);
        return "Order created";
    }
    @GetMapping("/{userName}")
    public List<OrderDTO> getOdersByUserName(@PathVariable String userName) {
        return orderService.getOrdersByUserName(userName);
    }
}
