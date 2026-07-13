package com.afrosoft.nqobile.onboardingandkyc.model;

import com.afrosoft.nqobile.onboardingandkyc.converter.CryptoConverter;
import com.afrosoft.nqobile.onboardingandkyc.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "kyc_applications")
public class KycApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;

    // Field-level AES-256 Encryption handled via JPA Converter
    @Column(name = "national_id_number", nullable = false)
    @Convert(converter = CryptoConverter.class)
    private String nationalIdNumber;

    @Column(name = "id_document_ref", nullable = false, length = 512)
    private String idDocumentRef; // S3/Object Storage bucket path

    @Column(name = "liveness_score", nullable = false, precision = 5, scale = 2)
    private BigDecimal livenessScore;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_status", nullable = false)
    private VerificationStatus verificationStatus;
}
