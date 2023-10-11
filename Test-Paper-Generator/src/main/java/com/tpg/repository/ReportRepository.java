package com.tpg.repository;

import com.tpg.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    // You can define custom query methods here if needed
}
