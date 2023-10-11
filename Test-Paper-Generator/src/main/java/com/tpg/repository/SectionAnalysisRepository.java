package com.tpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tpg.entity.SectionAnalysis;

public interface SectionAnalysisRepository extends JpaRepository<SectionAnalysis, Integer> {
    // You can add custom query methods here if needed
}

