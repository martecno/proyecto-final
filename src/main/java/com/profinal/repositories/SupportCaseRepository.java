package com.profinal.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profinal.entities.SupportCase;

public interface SupportCaseRepository extends JpaRepository<SupportCase, Long> {

	List<SupportCase> findAllByDateBetween(LocalDateTime init, LocalDateTime end);
	
	List<SupportCase> findAllByClientId(Long clientId);
	
}
