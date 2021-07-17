package com.profinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profinal.services.AdminService;
import com.profinal.services.ClientService;

@Controller
@RequestMapping("/")
public class MainController {

	private final ClientService clientService;
	private final AdminService adminsService;

	@Autowired
	public MainController(ClientService clientService, AdminService adminService) {
		this.clientService = clientService;
		this.adminsService = adminService;
	}

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
		model.addAttribute("clients", clientService.getClients());
		return "client";
	}

	@GetMapping(value = "/admin")
	public String admins(Model model) {
		model.addAttribute("admins", adminsService.getAdmins());
		return "admin";
	}

}
