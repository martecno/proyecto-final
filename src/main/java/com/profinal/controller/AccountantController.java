package com.profinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	private final AccountantService accountantService;

	@Autowired
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
			@RequestParam(value = "lastname") String lastname, @RequestParam(value = "cell") String cell,
			@RequestParam(value = "email") String email, @RequestParam(value = "password") String password,
			Model model) {

		Accountant accountant = new Accountant();
		accountant.setName(name);
		accountant.setLastname(lastname);
		accountant.setCell(cell);
		accountant.setEmail(email);
		accountant.setPassword(password);
		accountant = accountantService.save(accountant);
		return "redirect:/success";
	}

}
