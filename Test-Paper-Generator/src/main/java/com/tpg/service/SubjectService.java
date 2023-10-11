package com.tpg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpg.entity.Subject;
import com.tpg.repository.SubjectRepository;


@Service
public class SubjectService {
	@Autowired
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject findById(Integer subject_id) {
        return subjectRepository.findById(subject_id).orElse(null);
    }

    public Subject save(Subject doctor) {        
        return subjectRepository.save(doctor);
    }

    public void deleteById(Integer subject_id) {
        subjectRepository.deleteById(subject_id);
    }

	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

}
