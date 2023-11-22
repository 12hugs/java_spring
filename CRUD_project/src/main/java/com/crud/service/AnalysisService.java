package com.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.entity.Analysis;
import com.crud.repository.AnalysisRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private AnalysisRepository analysisRepository;

    public void imgSave(Analysis analysis) {
    	analysisRepository.save(analysis);
    }

	public List<Analysis> analysisList() {
		
		return analysisRepository.findAll();
	}
}
