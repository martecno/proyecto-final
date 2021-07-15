package com.profinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profinal.entities.Client;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping(value = "/calendar")
	public String calendar() {
		return "calendar";
	}

	@GetMapping(value = "/supportcase")
	public String supportcase() {
		return "supportcase";
	}

	@GetMapping(value = "/client")
	public String client(Model model) {
		List<Client> clientList = new ArrayList<>();
		Client pepe = new Client();
		pepe.setName("Pepe");
		pepe.setDirection("Siempre Vivas");
		pepe.setCuit(2020200202020l);
		clientList.add(pepe);
		model.addAttribute("clients", clientList);
		return "client";
	}

}
