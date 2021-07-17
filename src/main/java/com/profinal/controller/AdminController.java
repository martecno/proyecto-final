package com.profinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.profinal.entities.Admin;
import com.profinal.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private final AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("admin", new Admin());
		return "newAdmin";
	}

	@PostMapping(value = "/create")
	public String createAdmin(@RequestParam(value = "name") String name,
			@RequestParam(value = "lastname") String lastname, @RequestParam(value = "cell") String cell,
			@RequestParam(value = "email") String email, @RequestParam(value = "password") String password,
			Model model) {

		Admin admin = new Admin();
		admin.setName(name);
		admin.setLastname(lastname);
		admin.setCell(cell);
		admin.setEmail(email);
		admin.setPassword(password);
		admin = adminService.save(admin);
		System.out.println(String.format("Se creó el usuario con id: %s", admin.getId()));
		return "redirect:/";
	}

}
