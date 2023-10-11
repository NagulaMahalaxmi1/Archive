package com.tpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpg.entity.Question;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Integer> {
    List<Question> findBySubjectSubjectId(int subjectId);

}
