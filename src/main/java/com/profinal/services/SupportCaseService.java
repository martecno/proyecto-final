package com.profinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profinal.entities.SupportCase;
import com.profinal.repositories.SupportCaseRepository;

@Service
public class SupportCaseService {

	@Autowired
	private SupportCaseRepository supportRepository;
	
	public SupportCase saveSupport(SupportCase sc) {
		return supportRepository.saveAndFlush(sc);
	}
}
