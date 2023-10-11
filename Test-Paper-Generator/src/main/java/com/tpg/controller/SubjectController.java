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

    @GetMapping("/id/{subject_id}")
    public Subject getSubjectById(@PathVariable Integer subject_id) {
        return subjectService.findById(subject_id);
    }

    @PostMapping("/create")
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }

    @PutMapping("/update/{subject_id}")
    public Subject updateSubject(@PathVariable Integer subject_id, @RequestBody Subject subject) {
        subject.setSubject_id(subject_id);
        return subjectService.save(subject);
    }

    @DeleteMapping("/delete/{subject_id}")
    public void delete(@PathVariable Integer subject_id) {
		Subject subject = subjectService.findById(subject_id);
        if (subject != null) {
        	subjectService.deleteById(subject_id);
        }
    }

}
