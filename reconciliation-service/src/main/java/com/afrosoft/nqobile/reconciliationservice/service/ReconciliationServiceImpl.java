package com.afrosoft.nqobile.reconciliationservice.service;

import com.afrosoft.nqobile.reconciliationservice.api.V1ApiDelegate;
import com.afrosoft.nqobile.reconciliationservice.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReconciliationServiceImpl implements V1ApiDelegate {


    @Override
    public ResponseEntity<ChainSyncResponse> auditChainSync(AuditChainSyncRequest auditChainSyncRequest) {
        return V1ApiDelegate.super.auditChainSync(auditChainSyncRequest);
    }

    @Override
    public ResponseEntity<BankStatementResponse> processBankStatement(BankStatementPayload bankStatementPayload) {
        return V1ApiDelegate.super.processBankStatement(bankStatementPayload);
    }

    @Override
    public ResponseEntity<BreakResolutionResponse> resolveBreak(UUID breakId, BreakResolutionRequest breakResolutionRequest) {
        return V1ApiDelegate.super.resolveBreak(breakId, breakResolutionRequest);
    }
}
