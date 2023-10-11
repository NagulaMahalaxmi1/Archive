package com.tpg.service;

import com.tpg.entity.SectionAnalysis;
import com.tpg.repository.SectionAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionAnalysisService {

    private final SectionAnalysisRepository sectionAnalysisRepository;

    @Autowired
    public SectionAnalysisService(SectionAnalysisRepository sectionAnalysisRepository) {
        this.sectionAnalysisRepository = sectionAnalysisRepository;
    }

    public SectionAnalysis getSectionAnalysisById(Integer analysisId) {
        Optional<SectionAnalysis> optionalSectionAnalysis = sectionAnalysisRepository.findById(analysisId);
        return optionalSectionAnalysis.orElse(null);
    }

    public List<SectionAnalysis> getAllSectionAnalyses() {
        return sectionAnalysisRepository.findAll();
    }

    public SectionAnalysis createSectionAnalysis(SectionAnalysis sectionAnalysis) {
        return sectionAnalysisRepository.save(sectionAnalysis);
    }

    public SectionAnalysis updateSectionAnalysis(Integer analysisId, SectionAnalysis sectionAnalysis) {
        Optional<SectionAnalysis> optionalSectionAnalysis = sectionAnalysisRepository.findById(analysisId);
        if (optionalSectionAnalysis.isPresent()) {
            sectionAnalysis.setAnalysis_id(analysisId);
            return sectionAnalysisRepository.save(sectionAnalysis);
        } else {
            return null;
        }
    }

    public boolean deleteSectionAnalysis(Integer analysisId) {
        Optional<SectionAnalysis> optionalSectionAnalysis = sectionAnalysisRepository.findById(analysisId);
        if (optionalSectionAnalysis.isPresent()) {
            sectionAnalysisRepository.deleteById(analysisId);
            return true;
        } else {
            return false;
        }
    }
}
