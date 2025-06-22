package com.amvb.controller;

import com.amvb.DTOs.OrderDTO;
import com.amvb.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("payments")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> processPayment(@RequestBody OrderDTO orderDTO) {
        log.info("Received Order DTO : {}", orderDTO);
        paymentService.processPayment(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = paymentService.createOrder(data);

        if (response.containsKey("error-message")) {
            log.error("Error message: {}", response.get("error-message"));
            return ResponseEntity.badRequest().body(response.get("error-message"));
        }
        return ResponseEntity.ok(Map.of(
                "id", response.get("id"),
                "amount", response.get("amount"),
                "currency", response.get("currency")
        ));
    }


    @PostMapping("/verify")
    public ResponseEntity<String> verifyPayment(@RequestBody Map<String, String> data) {
        String response = paymentService.verifyPayment(data);
        if (response.equals("success")) {
            return ResponseEntity.ok("Payment verified successfully!");
        }
        return ResponseEntity.status(500).body(new Exception(response).getMessage());
    }
}
