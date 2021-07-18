package com.profinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.profinal.entities.Client;
import com.profinal.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	private final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
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

}
