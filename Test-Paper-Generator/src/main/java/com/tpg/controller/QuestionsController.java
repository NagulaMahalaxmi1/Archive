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

import com.tpg.entity.Question;
import com.tpg.service.QuestionsService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

	@Autowired
    private QuestionsService questionsService;

//    public QuestionsController(QuestionsService questionsService) {
//        this.questionsService = questionsService;
//    }

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionsService.findAll();
    }

    @GetMapping("/id/{q_id}")
    public Question getQuestionsById(@PathVariable int q_id) {
        return questionsService.findById(q_id);
    }

    @PostMapping("/create")
    public Question createQuestions(@RequestBody Question question) {
        return questionsService.createQuestions(question);
    }
    
    @PostMapping("/createMultiple")
    public List<Question> createMultipleQuestions(@RequestBody List<Question> questions) {
        return questionsService.createMultipleQuestions(questions);
    }
    
    @PutMapping("/update/{q_id}")
    public Question updateQuestions(@PathVariable int q_id, @RequestBody Question questions) {
        questions.setQ_id(q_id);
        return questionsService.updateQuestions(q_id, questions);
    }

    @DeleteMapping("/delete/{q_id}")
    public void delete(@PathVariable int q_id) {
		Question questions = questionsService.findById(q_id);
        if (questions != null) {
        	questionsService.deleteQuestions(q_id);
        }
    }


}

