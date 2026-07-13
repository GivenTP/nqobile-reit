package com.afrosoft.nqobile.reconciliationservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "reconciliation_ledger")
public class ReconciliationLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "payment_reference", nullable = false, length = 50)
    private String paymentReference;

    @Column(name = "bank_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal bankAmount;

    @Column(name = "on_chain_mint_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal onChainMintAmount; // Evaluated against on-chain mints [cite: 116]

    @Column(name = "break_detected", nullable = false)
    private Boolean breakDetected = false; // System halts primary token pipeline if true [cite: 116]
}
