package com.tpg.controller;

import com.tpg.entity.SectionAnalysis;
import com.tpg.service.SectionAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section-analysis")
public class SectionAnalysisController {

    private final SectionAnalysisService sectionAnalysisService;

    @Autowired
    public SectionAnalysisController(SectionAnalysisService sectionAnalysisService) {
        this.sectionAnalysisService = sectionAnalysisService;
    }

    @GetMapping("/{analysisId}")
    public ResponseEntity<SectionAnalysis> getSectionAnalysisById(@PathVariable Integer analysisId) {
        SectionAnalysis sectionAnalysis = sectionAnalysisService.getSectionAnalysisById(analysisId);
        if (sectionAnalysis != null) {
            return new ResponseEntity<>(sectionAnalysis, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<SectionAnalysis>> getAllSectionAnalyses() {
        List<SectionAnalysis> sectionAnalyses = sectionAnalysisService.getAllSectionAnalyses();
        if (!sectionAnalyses.isEmpty()) {
            return new ResponseEntity<>(sectionAnalyses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<SectionAnalysis> createSectionAnalysis(@RequestBody SectionAnalysis sectionAnalysis) {
        SectionAnalysis createdSectionAnalysis = sectionAnalysisService.createSectionAnalysis(sectionAnalysis);
        return new ResponseEntity<>(createdSectionAnalysis, HttpStatus.CREATED);
    }

    @PutMapping("/update/{analysisId}")
    public ResponseEntity<SectionAnalysis> updateSectionAnalysis(
            @PathVariable Integer analysisId, @RequestBody SectionAnalysis sectionAnalysis) {
        SectionAnalysis updatedSectionAnalysis = sectionAnalysisService.updateSectionAnalysis(analysisId, sectionAnalysis);
        if (updatedSectionAnalysis != null) {
            return new ResponseEntity<>(updatedSectionAnalysis, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{analysisId}")
    public ResponseEntity<Void> deleteSectionAnalysis(@PathVariable Integer analysisId) {
        boolean deleted = sectionAnalysisService.deleteSectionAnalysis(analysisId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
