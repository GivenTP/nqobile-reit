package com.afrosoft.nqobile.reportingandsupervision.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "regulatory_audit_logs")
public class RegulatoryAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String actor; // e.g., SYSTEM_RECON, OPERATOR_MLRO [cite: 114]

    @Column(name = "action_type", nullable = false, length = 100)
    private String actionType; // e.g., IDENTITY_REVOCATION, MANUAL_FREEZE [cite: 136]

    @Column(name = "payload_hash", nullable = false, length = 64)
    private String payloadHash; // SHA-256 system configuration footprint [cite: 96]

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}