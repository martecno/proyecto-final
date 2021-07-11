package com.profinal.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profinal.entities.User;

@Repository
@Transactional
public interface AdminRepository extends JpaRepository<User, Long> {

}