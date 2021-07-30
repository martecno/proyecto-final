package com.profinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.profinal.entities.Admin;
import com.profinal.repositories.AdminRepository;
import com.profinal.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final AdminService adminService;
	private AdminRepository adminRepository;

	@Autowired
	public AdminController(AdminService adminService, AdminRepository adminRepository) {
		this.adminService = adminService;
		this.adminRepository = adminRepository;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("admin", new Admin());
		return "newAdmin";
	}

	@GetMapping("/edit/{id}")
	public String editAdmin(@PathVariable(name = "id", required = true) Long id, Model model) {
		Optional<Admin> adminOp = adminRepository.findById(id);
		if (!adminOp.isPresent())
			return "redirect:error";

		model.addAttribute("admin", adminOp.get());
		return "newAdmin";
	}

	@PostMapping("/save")
	public String save(@Validated Admin admin, Model model) {
		adminService.save(admin);
		return "redirect:/person";
	}

	@GetMapping("/newAdmin")
	public String createAccountant(Model model) {
		model.addAttribute("admin", new Admin());
		return "newAdmin";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		adminService.delete(id);
		return "redirect:/person";
	}

}