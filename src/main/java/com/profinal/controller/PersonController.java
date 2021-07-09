package com.profinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profinal.entities.User;
import com.profinal.repositories.UserRepository;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(value = "/new")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "newUser";
	}

}
