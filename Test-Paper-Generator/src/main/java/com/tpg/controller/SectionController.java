package com.tpg.controller;

import com.tpg.entity.Section;
import com.tpg.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/{section_id}")
    public ResponseEntity<Section> getSectionById(@PathVariable int section_id) {
        Section section = sectionService.findSectionById(section_id);
        return ResponseEntity.ok(section);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Section>> getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        return ResponseEntity.ok(sections);
    }

    @PostMapping("/create")
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        Section createdSection = sectionService.createSection(section);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSection);
    }

    @PutMapping("/update/{section_id}")
    public ResponseEntity<Section> updateSection(@PathVariable int section_id, @RequestBody Section section) {
        Section updatedSection = sectionService.updateSection(section_id, section);
        return ResponseEntity.ok(updatedSection);
    }

    @DeleteMapping("/delete/{section_id}")
    public ResponseEntity<Void> deleteSection(@PathVariable int section_id) {
        sectionService.deleteSectionById(section_id);
        return ResponseEntity.noContent().build();
    }
    
//    @PostMapping("/addQuestions/{section_id}/{numberOfQuestions}")
//    public ResponseEntity<Section> addRandomQuestionsToSection(@PathVariable int section_id, @PathVariable int numberOfQuestions) {
//        Section section = sectionService.findSectionById(section_id);
//        if (section == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Section updatedSection = sectionService.addRandomQuestionsToSection(section, numberOfQuestions);
//        return ResponseEntity.ok(updatedSection);
//    }
}
