package com.profinal.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profinal.entities.Client;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Long> {

}
