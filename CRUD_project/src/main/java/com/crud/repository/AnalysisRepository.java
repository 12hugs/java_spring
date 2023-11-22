package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Analysis;

public interface AnalysisRepository extends JpaRepository<Analysis, Long>{
	
}
