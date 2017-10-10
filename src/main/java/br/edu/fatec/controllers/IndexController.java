package br.edu.fatec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class IndexController {
	
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("Executando a lógica com Spring MVC");
		return "index";
	}
	
	
	

}
