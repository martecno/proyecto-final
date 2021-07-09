package com.profinal.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profinal.entities.Person;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Person, Long> {

}