package com.tpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpg.entity.Subject;
import com.tpg.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired
    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/all")
    public List<Subject> getAllSubjects() {
        return subjectService.findAll();
    }

    @GetMapping("/id/{subjectId}")
    public Subject getSubjectById(@PathVariable Integer subjectId) {
        return subjectService.findById(subjectId);
    }

    @PostMapping("/create")
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }

    @PutMapping("/update/{subjectId}")
    public Subject updateSubject(@PathVariable Integer subjectId, @RequestBody Subject subject) {
    	subject.setSubjectId(subjectId);
        return subjectService.save(subject);
    }

    @DeleteMapping("/delete/{subjectId}")
    public void delete(@PathVariable Integer subjectId) {
		Subject subject = subjectService.findById(subjectId);
        if (subject != null) {
        	subjectService.deleteById(subjectId);
        }
    }

}
