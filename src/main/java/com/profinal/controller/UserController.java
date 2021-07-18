package com.profinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.profinal.entities.User;
import com.profinal.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "newUser";
	}

	@PostMapping(value = "/create")
	public String createUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "lastname") String lastname, @RequestParam(value = "cell") String cell,
			@RequestParam(value = "email") String email, @RequestParam(value = "password") String password,
			Model model) {

		User user = new User();
		user.setName(name);
		user.setLastname(lastname);
		user.setCell(cell);
		user.setEmail(email);
		user.setPassword(password);
		user = userService.save(user);
		return "redirect:/success";
	}

}
