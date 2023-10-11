package com.tpg.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tpg.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
	// In SectionRepository
	@Query("SELECT s FROM Section s LEFT JOIN FETCH s.questions WHERE s.section_id = :sectionId")
	Section findSectionWithQuestions(@Param("sectionId") int sectionId);


}
