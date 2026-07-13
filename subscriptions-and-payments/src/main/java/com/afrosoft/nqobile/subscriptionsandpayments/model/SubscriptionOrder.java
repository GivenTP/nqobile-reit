package com.afrosoft.nqobile.subscriptionsandpayments.model;

import com.afrosoft.nqobile.subscriptionsandpayments.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "subscription_orders")
public class SubscriptionOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "investor_id", nullable = false)
    private UUID investorId;

    @Column(name = "target_amount_usd", nullable = false, precision = 12, scale = 2)
    private BigDecimal targetAmountUsd; // Minimum $2/day equivalent rule validation [cite: 27]

    @Column(name = "payment_reference", nullable = false, unique = true, length = 50)
    private String paymentReference;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

}