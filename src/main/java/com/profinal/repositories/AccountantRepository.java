package com.profinal.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profinal.entities.Accountant;

@Repository
@Transactional
public interface AccountantRepository extends JpaRepository<Accountant, Long> {

}