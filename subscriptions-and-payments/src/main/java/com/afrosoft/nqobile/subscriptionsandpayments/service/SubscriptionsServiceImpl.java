package com.afrosoft.nqobile.subscriptionsandpayments.service;

import com.afrosoft.nqobile.subscriptionsandpayments.api.SubscriptionsApiDelegate;
import com.afrosoft.nqobile.subscriptionsandpayments.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubscriptionsServiceImpl implements SubscriptionsApiDelegate {


    @Override
    public ResponseEntity<CancelResponse> cancelSubscription(UUID orderId, CancelSubscriptionRequest cancelSubscriptionRequest) {
        return SubscriptionsApiDelegate.super.cancelSubscription(orderId, cancelSubscriptionRequest);
    }

    @Override
    public ResponseEntity<MatchingFeedResponse> getMatchingFeed(String status, Integer page, Integer pageSize) {
        return SubscriptionsApiDelegate.super.getMatchingFeed(status, page, pageSize);
    }

    @Override
    public ResponseEntity<SubscribeResponse> subscribe(SubscribeRequest subscribeRequest) {
        return SubscriptionsApiDelegate.super.subscribe(subscribeRequest);
    }
}
