package com.afrosoft.nqobile.distributionservice.model;

import com.afrosoft.nqobile.distributionservice.enums.CycleStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "distribution_cycles")
public class DistributionCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "snapshot_block_number", nullable = false)
    private Long snapshotBlockNumber; // Target Polygon block height for pro-rata parsing [cite: 119]

    @Column(name = "total_payout_usd", nullable = false, precision = 14, scale = 2)
    private BigDecimal totalPayoutUsd;

    @Column(name = "trustee_signed", nullable = false)
    private Boolean trusteeSigned = false; // Sign-off required by Kreston Zimbabwe [cite: 37, 370]

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CycleStatus status;

}
