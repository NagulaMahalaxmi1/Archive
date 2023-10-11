package com.tpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpg.entity.Question;
import com.tpg.entity.Section;
import com.tpg.entity.Subject;
import com.tpg.repository.QuestionsRepository;
import com.tpg.repository.SectionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    public SectionService(SectionRepository sectionRepository, QuestionsRepository questionsRepository) {
        this.sectionRepository = sectionRepository;
        this.questionsRepository = questionsRepository;
    }

//    // Create a new section with random questions
//    public Section generateRandomSection(int subjectId, int numberOfQuestions) {
//        // Get all questions for the given subject
//        List<Question> allQuestions = questionsRepository.findBySubjectSubjectId(subjectId);
//
//        // Check if there are enough questions available for the given subject
//        if (allQuestions.size() < numberOfQuestions) {
//            throw new IllegalArgumentException("Not enough questions available for the subject.");
//        }
//
//        // Shuffle the questions and select the first 'numberOfQuestions' questions
//        List<Question> randomQuestions = getRandomQuestions(allQuestions, numberOfQuestions);
//
//        // Create a new Section object
//        Section section = new Section();
//        Subject subject = new Subject();
//        subject.setSubjectId(subjectId);
//        section.setSubject(subject);
//        section.setNumberOfQuestions(numberOfQuestions);
//        section.setQuestions(randomQuestions);
//
//        // Save the section to the database
//        sectionRepository.save(section);
//
//        return section;
//    }

    public Section generateRandomSection(int subjectId, int numberOfQuestions) {
        // Get all questions for the given subject
        List<Question> allQuestions = questionsRepository.findBySubjectSubjectId(subjectId);

        // Check if there are enough questions available for the given subject
        if (allQuestions.size() < numberOfQuestions) {
            throw new IllegalArgumentException("Not enough questions available for the subject.");
        }

        // Shuffle the questions and select the first 'numberOfQuestions' questions
        List<Question> randomQuestions = getRandomQuestions(allQuestions, numberOfQuestions);

        // Create a new Section object
        Section section = new Section();
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        section.setSubject(subject);
        section.setNumberOfQuestions(numberOfQuestions);
        section.setQuestions(randomQuestions);
//        section.setGeneratedQuestions(randomQuestions); // Set the generated questions
//        // Save the generated questions to the database
//        sectionRepository.save(randomQuestions);
//        
//        // Save the section to the database
//        sectionRepository.save(section);

        return section;
    }
    
    public Question SaveGeneratedQuestions(Question randomQuestions) {
		return ;
    	
    }

    // Get all sections
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }
    
    public Section getSectionById(int section_id) {
        return sectionRepository.findSectionWithQuestions(section_id);
    }
    

//    // Get a section by ID
//    public Section getSectionById(int section_id) {
//        return sectionRepository.findById(section_id).orElse(null);
//    }

    // Create a new section
    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    // Update a section
    public Section updateSection(int section_id, Section updatedSection) {
        updatedSection.setSection_id(section_id);
        return sectionRepository.save(updatedSection);
    }

    // Delete a section by ID
    public void deleteSection(int section_id) {
        sectionRepository.deleteById(section_id);
    }

    private List<Question> getRandomQuestions(List<Question> questions, int numberOfQuestions) {
        List<Question> randomQuestions = new ArrayList<>();
        Random random = new Random();

        while (randomQuestions.size() < numberOfQuestions) {
            int randomIndex = random.nextInt(questions.size());
            Question randomQuestion = questions.get(randomIndex);

            // Check if the question is not already in the list
            if (!randomQuestions.contains(randomQuestion)) {
                randomQuestions.add(randomQuestion);
            }
        }

        return randomQuestions;
    }

}
