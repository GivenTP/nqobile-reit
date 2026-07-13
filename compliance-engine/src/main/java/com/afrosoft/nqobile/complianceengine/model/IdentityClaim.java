package com.afrosoft.nqobile.complianceengine.model;

import com.afrosoft.nqobile.complianceengine.enums.OnChainStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "identity_claims")
public class IdentityClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "investor_id", nullable = false)
    private UUID investorId;

    @Column(name = "claim_type", nullable = false)
    private Integer claimType; // 1: KYC Tier, 2: Jurisdiction, 3: Investor Class [cite: 135]

    @Column(name = "claim_value", nullable = false)
    private String claimValue;

    @Column(nullable = false)
    private byte[] signature; // Cryptographic proof issued by Afrosoft [cite: 135]

    @Enumerated(EnumType.STRING)
    @Column(name = "on_chain_status", nullable = false)
    private OnChainStatus onChainStatus;

}