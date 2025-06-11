package com.amvb.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private UUID orderId;
    private UUID paymentId;
    private String transactionId;
    private String userName;
    private Double amountPaid;
    private LocalDateTime orderCreatedTime;
    private String orderStatus;
}
