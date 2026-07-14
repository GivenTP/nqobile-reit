package com.afrosoft.nqobile.complianceengine.service;

import com.afrosoft.nqobile.complianceengine.api.V1ApiDelegate;
import com.afrosoft.nqobile.complianceengine.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ComplianceServiceImpl implements V1ApiDelegate {

    @Override
    public ResponseEntity<CaseDispositionResponse> resolveComplianceCase(UUID caseId, CaseDispositionRequest caseDispositionRequest) {
        return V1ApiDelegate.super.resolveComplianceCase(caseId, caseDispositionRequest);
    }

    @Override
    public ResponseEntity<ApplicantScreeningResponse> screenApplicant(ApplicantScreeningRequest applicantScreeningRequest) {
        return V1ApiDelegate.super.screenApplicant(applicantScreeningRequest);
    }

    @Override
    public ResponseEntity<TransactionScreeningResponse> screenTransaction(TransactionScreeningRequest transactionScreeningRequest) {
        return V1ApiDelegate.super.screenTransaction(transactionScreeningRequest);
    }
}
