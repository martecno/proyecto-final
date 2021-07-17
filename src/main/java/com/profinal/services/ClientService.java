package com.profinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profinal.entities.Client;
import com.profinal.repositories.ClientRepository;

@Service
public class ClientService {
	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client save(Client client) {
		return clientRepository.saveAndFlush(client);
	}

	public List<Client> getClients() {
		return clientRepository.findAll();
	}

}
