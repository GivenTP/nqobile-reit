package com.afrosoft.nqobile.transferservice.service;

import com.afrosoft.nqobile.transferservice.api.TransfersApiDelegate;
import com.afrosoft.nqobile.transferservice.model.TransferPreCheckRequest;
import com.afrosoft.nqobile.transferservice.model.TransferPreCheckResponse;
import com.afrosoft.nqobile.transferservice.model.TransferSubmitRequest;
import com.afrosoft.nqobile.transferservice.model.TransferSubmitResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransfersServiceImpl implements TransfersApiDelegate {


    @Override
    public ResponseEntity<TransferPreCheckResponse> preCheckTransfer(TransferPreCheckRequest transferPreCheckRequest) {
        return TransfersApiDelegate.super.preCheckTransfer(transferPreCheckRequest);
    }

    @Override
    public ResponseEntity<TransferSubmitResponse> submitTransfer(TransferSubmitRequest transferSubmitRequest) {
        return TransfersApiDelegate.super.submitTransfer(transferSubmitRequest);
    }
}
