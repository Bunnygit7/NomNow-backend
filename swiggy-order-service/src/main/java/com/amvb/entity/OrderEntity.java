package com.amvb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;
    @Column(name = "payment_id")
    private UUID paymentId;
    @Column(name = "txn_id")
    private String transactionId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "amount_paid")
    private Double amountPaid;
    @Column(name = "order_created_date_time")
    private LocalDateTime orderCreatedTime;
    @Column(name = "order_status")
    private String orderStatus;
}
