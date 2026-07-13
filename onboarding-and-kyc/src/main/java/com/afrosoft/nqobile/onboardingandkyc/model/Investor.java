package com.afrosoft.nqobile.onboardingandkyc.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "investors")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, length = 10)
    private String jurisdiction; // ISO code (e.g., ZW, GB) [cite: 31]

    @Enumerated(EnumType.STRING)
    @Column(name = "investor_class", nullable = false)
    private InvestorClass investorClass; // RETAIL, HNWI, CORPORATE [cite: 135]

    @Column(name = "onchain_id_address", length = 42, unique = true)
    private String onchainIdAddress; // ONCHAINID EVM address [cite: 92, 134]

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvestorStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum InvestorClass { RETAIL, HNWI, CORPORATE }
    public enum InvestorStatus { PENDING, VERIFIED, SUSPENDED }
}
