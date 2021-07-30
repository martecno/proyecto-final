package com.profinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profinal.entities.Accountant;
import com.profinal.repositories.AccountantRepository;

@Service
public class AccountantService {
	private final AccountantRepository accountantRepository;

	@Autowired
	public AccountantService(AccountantRepository accountantRepository) {
		this.accountantRepository = accountantRepository;
	}

	public Accountant save(Accountant accountant) {
		return accountantRepository.saveAndFlush(accountant);
	}

	public List<Accountant> getAccountants() {
		return accountantRepository.findAll();
	}

	public Optional<Accountant> getId(Long id) {
		return accountantRepository.findById(id);
	}

	public void delete(Long id) {
		accountantRepository.deleteById(id);
	}

}