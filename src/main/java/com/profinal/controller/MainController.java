package com.profinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profinal.entities.Accountant;
import com.profinal.entities.Admin;
import com.profinal.entities.User;
import com.profinal.services.AccountantService;
import com.profinal.services.AdminService;
import com.profinal.services.ClientService;
import com.profinal.services.UserService;

@Controller
@RequestMapping("/")
public class MainController {

	private final ClientService clientService;
	private final AdminService adminsService;
	private final UserService usersService;
	private final AccountantService accountantsService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@Autowired
	public MainController(ClientService clientService, AdminService adminService, UserService userService,
			AccountantService accountantService) {
		this.clientService = clientService;
		this.adminsService = adminService;
		this.usersService = userService;
		this.accountantsService = accountantService;
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

	@GetMapping(value = "/person")
	public String admins(Model model) {
		model.addAttribute("admins", adminsService.getAdmins());
		model.addAttribute("users", usersService.getUsers());
		model.addAttribute("accountants", accountantsService.getAccountants());
		return "person";
	}

	@GetMapping(value = "/success")
	public String submitForm(@ModelAttribute("user") User user, @ModelAttribute("admin") Admin admin,
			@ModelAttribute("accountant") Accountant accountant) {
		return "success";
	}

}
