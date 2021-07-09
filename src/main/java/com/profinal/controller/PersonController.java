package com.profinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.profinal.repositories.UserRepository;

@Controller
@RequestMapping("/person")
public interface PersonController {

	@Autowired
	private UserRepository userrepository;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createUser(Model model) {
		model.addAttribute("person", new User());
		return "newPerson";
	}

}
