package io.github.todolistapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.todolistapp.entity.Encomium;
import io.github.todolistapp.service.EncomiumService;

@Controller
public class EncomiumController {
	
	@Autowired
	private EncomiumService encomiumService;
	
	@RequestMapping(value = "/encomium")
	public String encomium(Model model) {
		List<Encomium> allEncomium = encomiumService.getAllEncomium();
		model.addAttribute("allEncomium", allEncomium);
		
		return "encomium";
	}
	
	@RequestMapping(value = "/encomium/create", method = RequestMethod.POST)
	public String createEncomium(Model model, @ModelAttribute Encomium encomium) {
		encomiumService.addEncomium(encomium);
		
		return "redirect:/encomium";
	}
}
