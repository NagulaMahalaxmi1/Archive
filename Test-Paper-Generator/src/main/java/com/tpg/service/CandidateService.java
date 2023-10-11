package com.tpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpg.entity.Candidate;
import com.tpg.repository.CandidateRepository;

import java.util.List;

@Service
public class CandidateService {
	
    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId).orElse(null);
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Long candidateId, Candidate candidate) {
        if (candidateRepository.existsById(candidateId)) {
            candidate.setCandidateId(candidateId);
            return candidateRepository.save(candidate);
        } else {
            return null;
        }
    }

    public void deleteCandidate(Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }
}