package com.afrosoft.nqobile.onboardingandkyc.service;

import com.afrosoft.nqobile.onboardingandkyc.api.OnboardApiDelegate;
import com.afrosoft.nqobile.onboardingandkyc.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class OnboardServiceImpl implements OnboardApiDelegate {


    @Override
    public ResponseEntity<KycStatusResponse> getKycStatus(UUID userId) {
        return OnboardApiDelegate.super.getKycStatus(userId);
    }

    @Override
    public ResponseEntity<RegisterResponse> registerInvestor(RegisterRequest registerRequest) {
        return OnboardApiDelegate.super.registerInvestor(registerRequest);
    }

    @Override
    public ResponseEntity<Void> resendOtp(ResendOtpRequest resendOtpRequest) {
        return OnboardApiDelegate.super.resendOtp(resendOtpRequest);
    }

    @Override
    public ResponseEntity<KycSubmitResponse> submitDocuments(String documentType, MultipartFile documentFile, MultipartFile selfie) {
        return OnboardApiDelegate.super.submitDocuments(documentType, documentFile, selfie);
    }

    @Override
    public ResponseEntity<AuthTokenResponse> verifyOtp(OtpVerifyRequest otpVerifyRequest) {
        return OnboardApiDelegate.super.verifyOtp(otpVerifyRequest);
    }
}
