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

import com.profinal.entities.User;
import com.profinal.repositories.UserRepository;
import com.profinal.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	private UserRepository userRepository;

	User user = new User();

	public UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "newUser";
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable(name = "id", required = true) Long id, Model model) {
		Optional<User> userOp = userRepository.findById(id);
		if (!userOp.isPresent())
			return "redirect:error";

		model.addAttribute("user", userOp.get());
		return "editUser";
	}

	@PostMapping("/save")
	public String save(@Validated User user, Model model) {
		userService.save(user);
		return "redirect:/person";
	}

	@GetMapping("/newUser")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "newUser";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		userService.delete(id);
		return "redirect:/person";
	}

}