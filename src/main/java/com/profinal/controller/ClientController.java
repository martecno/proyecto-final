package com.profinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.profinal.entities.Client;
import com.profinal.repositories.ClientRepository;
import com.profinal.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	private final ClientService clientService;
	private ClientRepository clientRepository;

	@Autowired
	public ClientController(ClientService clientService, ClientRepository clientRepository) {
		this.clientService = clientService;
		this.clientRepository = clientRepository;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newClient(Model model) {
		model.addAttribute("client", new Client());
		return "newClient";
	}

	@PostMapping(value = "/create")
	public String createClient(@RequestParam(value = "name") String name,
			@RequestParam(value = "direction") String direction, @RequestParam(value = "cuit") Long cuit, Model model) {

		Client client = new Client();
		client.setName(name);
		client.setDirection(direction);
		client.setCuit(cuit);
		client = clientService.save(client);

		return "redirect:/successclient";
	}

	@GetMapping("/edit/{id}")
	public String editClient(@PathVariable(name = "id", required = true) Long id, Model model) {
		Optional<Client> clientOp = clientRepository.findById(id);
		if (!clientOp.isPresent())
			return "redirect:error";

		model.addAttribute("client", clientOp.get());
		return "editClient";
	}

	@PostMapping("/{id}")
	public String updateClient(@PathVariable(name = "id", required = true) Long id,
			@ModelAttribute(name = "client") Client client) {
		Optional<Client> clientOp = clientRepository.findById(id);
		if (!clientOp.isPresent() || client == null)
			return "redirect:error";

		clientRepository.save(client);
		return "redirect:/client";
	}

	@PostMapping("/save")
	public String save(@Validated Client client, Model model) {
		clientService.save(client);
		return "redirect:/client";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		clientService.delete(id);
		return "redirect:/client";
	}

}
