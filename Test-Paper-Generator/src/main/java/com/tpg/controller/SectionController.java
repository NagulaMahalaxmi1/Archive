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

    @Autowired
    private SectionService sectionService;

    @GetMapping("/all")
    public ResponseEntity<List<Section>> getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }

    @GetMapping("/id/{section_id}")
    public ResponseEntity<Section> getSectionById(@PathVariable("section_id") int section_id) {
        Section section = sectionService.getSectionById(section_id);
        if (section != null) {
            return new ResponseEntity<>(section, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        Section createdSection = sectionService.createSection(section);
        return new ResponseEntity<>(createdSection, HttpStatus.CREATED);
    }

    @PutMapping("/update/{section_id}")
    public ResponseEntity<Section> updateSection(
            @PathVariable("section_id") int section_id,
            @RequestBody Section updatedSection) {
        Section section = sectionService.updateSection(section_id, updatedSection);
        if (section != null) {
            return new ResponseEntity<>(section, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{section_id}")
    public ResponseEntity<Void> deleteSection(@PathVariable("section_id") int section_id) {
        sectionService.deleteSection(section_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/generate")
    public ResponseEntity<Section> generateRandomSection(
            @RequestParam("subjectId") int subjectId,
            @RequestParam("numberOfQuestions") int numberOfQuestions) {
        try {
            Section section = sectionService.generateRandomSection(subjectId, numberOfQuestions);
            return new ResponseEntity<>(section, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
