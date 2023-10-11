package com.tpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpg.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}