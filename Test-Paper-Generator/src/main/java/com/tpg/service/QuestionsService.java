package com.tpg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tpg.entity.Question;
import com.tpg.entity.Subject;
import com.tpg.repository.QuestionsRepository;

@Service
public class QuestionsService {
	
	@Autowired
    private QuestionsRepository questionsRepository;
	
	@Autowired
    private SubjectService subjectService; 
	
//	@Autowired
//    public QuestionsService(QuestionsRepository questionsRepository) {
//        this.questionsRepository = questionsRepository;
//    }

    public Iterable<Question> getAllQuestions() {
        return questionsRepository.findAll();
    }
    
    public QuestionsService(QuestionsRepository questionsRepository, SubjectService subjectService) {
		super();
		this.questionsRepository = questionsRepository;
		this.subjectService = subjectService;
	}

	public Question findById(int q_id) {
        return questionsRepository.findById(q_id).orElse(null);
    }
    
    public Question createQuestions(@RequestBody Question questions) {
    	int subjectId = questions.getSubject().getSubjectId(); 
        Subject subject = subjectService.findById(subjectId); 
        questions.setSubject(subject);
        return questionsRepository.save(questions);
    }
    
    public List<Question> createMultipleQuestions(List<Question> questions) {
        List<Question> savedQuestions = new ArrayList<>();
        
        for (Question question : questions) {
            int subjectId = question.getSubject().getSubjectId();
            Subject subject = subjectService.findById(subjectId);
            question.setSubject(subject);
            savedQuestions.add(questionsRepository.save(question));
        }
        
        return savedQuestions;
    }

    
    public Question updateQuestions(@PathVariable int q_id, @RequestBody Question questions) {
        questions.setQ_id(q_id);
        int subjectId = questions.getSubject().getSubjectId(); 
        Subject subject = subjectService.findById(subjectId); 
        questions.setSubject(subject);
        return questionsRepository.save(questions);
    }
    
    public void deleteQuestions(@PathVariable int q_id) {
		Optional<Question> questions = questionsRepository.findById(q_id);
        if (questions.isPresent()) { 
        	questionsRepository.deleteById(q_id);
        }
    }

    public List<Question> findAll() {
        return questionsRepository.findAll();
    }
}
