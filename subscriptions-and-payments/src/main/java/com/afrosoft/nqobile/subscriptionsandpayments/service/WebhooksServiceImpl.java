package com.afrosoft.nqobile.subscriptionsandpayments.service;

import com.afrosoft.nqobile.subscriptionsandpayments.api.WebhooksApiDelegate;
import com.afrosoft.nqobile.subscriptionsandpayments.model.PspWebhookPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WebhooksServiceImpl implements WebhooksApiDelegate {

    @Override
    public ResponseEntity<Void> pspPaymentWebhook(String xWebhookSignature, PspWebhookPayload pspWebhookPayload) {
        return WebhooksApiDelegate.super.pspPaymentWebhook(xWebhookSignature, pspWebhookPayload);
    }
}
