package br.com.avelar.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.avelar.frontend.api.PersonApiClient;

@Controller
@RequestMapping
public class PersonController {
	
	@Autowired
	private PersonApiClient personApi;
	
	@GetMapping
	public String findAllPeople(Model model) {
		model.addAttribute("peopleList", personApi.findAll());
		return "index";
	}
}
