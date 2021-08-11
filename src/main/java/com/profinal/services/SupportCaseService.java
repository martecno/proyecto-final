package com.profinal.services;

import java.util.List;

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

	public List<SupportCase> getSupports() {
		return supportRepository.findAll();
	}

}
