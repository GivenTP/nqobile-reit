package com.afrosoft.nqobile.onboardingandkyc.service;

import com.afrosoft.nqobile.onboardingandkyc.api.WebhooksApiDelegate;
import com.afrosoft.nqobile.onboardingandkyc.model.KycVendorCallback;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WebhookServiceImpl implements WebhooksApiDelegate {


    @Override
    public ResponseEntity<Void> kycVendorCallback(String xVendorSignature, KycVendorCallback kycVendorCallback) {
        return WebhooksApiDelegate.super.kycVendorCallback(xVendorSignature, kycVendorCallback);
    }
}
