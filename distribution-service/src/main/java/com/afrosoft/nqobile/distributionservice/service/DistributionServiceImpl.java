package com.afrosoft.nqobile.distributionservice.service;

import com.afrosoft.nqobile.distributionservice.api.V1ApiDelegate;
import com.afrosoft.nqobile.distributionservice.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DistributionServiceImpl implements V1ApiDelegate {

    @Override
    public ResponseEntity<TrusteeApprovalResponse> approveDistribution(UUID distributionId, TrusteeApprovalRequest trusteeApprovalRequest) {
        return V1ApiDelegate.super.approveDistribution(distributionId, trusteeApprovalRequest);
    }

    @Override
    public ResponseEntity<CalculationResponse> calculateDistribution(CalculationRequest calculationRequest) {
        return V1ApiDelegate.super.calculateDistribution(calculationRequest);
    }

    @Override
    public ResponseEntity<ExecutionResponse> executeDistribution(UUID distributionId) {
        return V1ApiDelegate.super.executeDistribution(distributionId);
    }
}
