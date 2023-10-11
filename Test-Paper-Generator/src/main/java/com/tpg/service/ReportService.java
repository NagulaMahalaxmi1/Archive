package com.tpg.service;

import com.tpg.entity.Report;
import com.tpg.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report getReportById(int reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);
        return optionalReport.orElse(null);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report updateReport(int reportId, Report report) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);
        if (optionalReport.isPresent()) {
            report.setReportId(reportId);
            return reportRepository.save(report);
        } else {
            return null;
        }
    }

    public boolean deleteReport(int reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);
        if (optionalReport.isPresent()) {
            reportRepository.deleteById(reportId);
            return true;
        } else {
            return false;
        }
    }
}
