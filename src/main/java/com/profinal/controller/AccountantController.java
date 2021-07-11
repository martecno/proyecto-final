package com.profinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.profinal.entities.Accountant;
import com.profinal.services.AccountantService;

@Controller
@RequestMapping("/accountant")
public class AccountantController {
	private static final Logger logger = LoggerFactory.getLogger(AccountantController.class);
	private final AccountantService accountantService;

	public AccountantController(AccountantService accountantService) {
		this.accountantService = accountantService;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newAccountant(Model model) {
		model.addAttribute("accountant", new Accountant());
		return "newAccountant";
	}

	@PostMapping(value = "/create")
	public String createAdmin(@RequestParam(value = "name") String name,
			@RequestParam(value = "lastname") String lastname, @RequestParam(value = "cell") String cell, Model model) {

		Accountant admin = new Accountant();
		admin.setName(name);
		admin.setLastname(lastname);
		admin.setCell(cell);
		admin = accountantService.save(admin);
		model.addAttribute("admin", admin);
		System.out.println(String.format("Se creó el usauario con id: %s", admin.getId()));
		return "redirect:/";
	}

}
