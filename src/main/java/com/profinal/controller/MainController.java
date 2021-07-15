package com.profinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping(value = "/calendar")
	public String calendar() {
		return "calendar";
	}

	@GetMapping(value = "/supportcase")
	public String supportcase() {
		return "supportcase";
	}

	@GetMapping(value = "/client")
	public String client() {
		return "client";
	}

}
