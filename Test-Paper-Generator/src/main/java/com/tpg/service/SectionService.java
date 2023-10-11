package com.tpg.service;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpg.entity.Questions;
import com.tpg.entity.Section;
import com.tpg.repository.SectionRepository;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;
    private final QuestionsService questionsService;

    @Autowired
    public SectionService(SectionRepository sectionRepository, QuestionsService questionsService) {
        this.sectionRepository = sectionRepository;
        this.questionsService = questionsService;
    }

    // Retrieve all sections
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }
    
    // Create a new section
    @Transactional
    public Section createSection(Section section) {
        // Validate the subject
        if (section.getSubject() == null) {
         throw new IllegalArgumentException("Section must be associated with a subject.");
        }        
        return sectionRepository.save(section);
    }

    // Update an existing section
    @Transactional
    public Section updateSection(int section_id, Section updatedSection) {
    	if (updatedSection.getSubject() == null) {
            throw new IllegalArgumentException("Section must be associated with a subject.");
           }         
    	return sectionRepository.save(updatedSection);
    }

    // Delete a section by ID
    @Transactional
    public void deleteSectionById(int section_id) {
        // You can add validation or other business logic here
        sectionRepository.deleteById(section_id);
    }

    // Find a section by ID
    public Section findSectionById(int section_id) {
        return sectionRepository.findById(section_id)
                .orElseThrow(() -> new EntityNotFoundException("Section with ID " + section_id + " not found"));
    }

    @Transactional
    public List<Questions> getRandomQuestionsForSection(Section section, int numberOfQuestions) {
    	int subject_id = section.getSubject().getSubject_id();
        int difficultyLevel = (section.getQuestions() != null) ? section.getQuestions().getLevel() : 0;

        // Retrieve all questions that match the subject and difficulty level
        List<Questions> matchingQuestions = questionsService.getQuestionsBySubjectAndLevel(subject_id, difficultyLevel);

        // Check if there are enough questions to meet the required number
        if (matchingQuestions.size() < numberOfQuestions) {
            throw new IllegalArgumentException("Not enough questions available for the specified subject and difficulty level.");
        }

        // Shuffle the list of matching questions
        shuffleList(matchingQuestions);

        // Select the first 'numberOfQuestions' questions
        return matchingQuestions.subList(0, numberOfQuestions);
    }

    // Helper method to shuffle a list
    private <T> void shuffleList(List<T> list) {
        Random random = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}