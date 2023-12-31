package com.tpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpg.entity.TestPaper;

@Repository
public interface TestPaperRepository extends JpaRepository<TestPaper, Integer> {

}
