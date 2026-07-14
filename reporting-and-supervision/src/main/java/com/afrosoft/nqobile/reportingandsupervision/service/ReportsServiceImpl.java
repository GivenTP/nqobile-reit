package com.afrosoft.nqobile.reportingandsupervision.service;

import com.afrosoft.nqobile.reportingandsupervision.api.ReportsApiDelegate;
import com.afrosoft.nqobile.reportingandsupervision.model.InvestorStatement;
import com.afrosoft.nqobile.reportingandsupervision.model.PortfolioSummary;
import com.afrosoft.nqobile.reportingandsupervision.model.ReportPackResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ReportsServiceImpl implements ReportsApiDelegate {


    @Override
    public ResponseEntity<InvestorStatement> getInvestorStatement(UUID userId, LocalDate from, LocalDate to) {
        return ReportsApiDelegate.super.getInvestorStatement(userId, from, to);
    }

    @Override
    public ResponseEntity<PortfolioSummary> getPortfolioSummary() {
        return ReportsApiDelegate.super.getPortfolioSummary();
    }

    @Override
    public ResponseEntity<ReportPackResponse> getReportingPack(String period, String format) {
        return ReportsApiDelegate.super.getReportingPack(period, format);
    }
}
