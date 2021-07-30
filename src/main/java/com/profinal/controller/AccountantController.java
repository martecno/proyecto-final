package com.profinal.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.profinal.entities.Accountant;
import com.profinal.repositories.AccountantRepository;
import com.profinal.services.AccountantService;

@Controller
@RequestMapping("/accountant")
public class AccountantController {
	private final AccountantService accountantService;
	private AccountantRepository accountantRepository;

	Accountant accountant = new Accountant();

	public AccountantController(AccountantService accountantService, AccountantRepository accountantRepository) {
		this.accountantService = accountantService;
		this.accountantRepository = accountantRepository;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newAccountant(Model model) {
		model.addAttribute("accountant", new Accountant());
		return "newAccountant";
	}

	@GetMapping("/edit/{id}")
	public String editAccountant(@PathVariable(name = "id", required = true) Long id, Model model) {
		Optional<Accountant> accountantOp = accountantRepository.findById(id);
		if (!accountantOp.isPresent())
			return "redirect:error";

		model.addAttribute("accountant", accountantOp.get());
		return "newAccountant";
	}

	@PostMapping("/save")
	public String save(@Validated Accountant accountant, Model model) {
		accountantService.save(accountant);
		return "redirect:/person";
	}

	@GetMapping("/newAccountant")
	public String createAccountant(Model model) {
		model.addAttribute("accountant", new Accountant());
		return "newAccountant";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		accountantService.delete(id);
		return "redirect:/person";
	}

}