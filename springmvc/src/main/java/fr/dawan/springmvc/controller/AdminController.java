package fr.dawan.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dawan.springmvc.service.IUserService;


/*
 * Un contrôleur Spring MVC est une classe qui est annotée @Controller (Obligatoire) 
 * 
 * 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IUserService service;
	
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public String lstUser() {
		return "users";
	}

}
