package com.profinal.controller;

import java.time.LocalDateTime;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profinal.dtos.SupportCaseDto;
import com.profinal.entities.Client;
import com.profinal.entities.SupportCase;
import com.profinal.services.ClientService;
import com.profinal.services.SupportCaseService;

@Controller
@RequestMapping("/supportcase")
public class SupportCaseController {

	private final ClientService clientService;
	private final SupportCaseService supportService;

	@Autowired
	public SupportCaseController(ClientService clientService, SupportCaseService supportService) {
		this.clientService = clientService;
		this.supportService = supportService;
	}

	@GetMapping("/{id}")
	public String newSupportCase(@PathVariable(value = "id", required = true) Long id, Model model) {
		Client client = clientService.getById(id);
		
		if (client == null)
			return "error";
		
		SupportCaseDto sc = new SupportCaseDto(client.getId(), client.getName(), LocalDateTime.now(), "");
		model.addAttribute("supportCase", sc);
		
		return "newSupportCase";
		
	}
	
	
	@PostMapping
	public String create(@ModelAttribute(name = "supportCase") SupportCaseDto dto, Model model) {
		Client client = clientService.getById(dto.getClientId());
		SupportCase sc = new SupportCase();
		sc.setClient(client);
		sc.setDate(dto.getDate());
		sc.setDescription(dto.getDescription());
		
		sc = supportService.saveSupport(sc);
		model.addAttribute("supportCase",sc);
		
		return "showSupportCase";
		
	}
	
}
