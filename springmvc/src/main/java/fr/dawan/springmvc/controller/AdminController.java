package fr.dawan.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.springmvc.entities.User;
import fr.dawan.springmvc.service.IUserService;


/*
 * Un contr�leur Spring MVC est une classe qui est annot�e @Controller (Obligatoire) 
 * 
 * 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IUserService service;
	
//	@RequestMapping(value="/users", method = RequestMethod.GET)
//	public String lstUser() {
//		return "users";
//	}
	
	@GetMapping("/users")
	public ModelAndView lstUser() {
		
		ModelAndView modelView = new ModelAndView();
		List<User> users = service.findAllUsers();
		modelView.setViewName("users");
		modelView.addObject("users", users);
		
		return modelView;
	}
	
	
	/*
	 * Admin pourra effacer un user par son id 
	 * 
	 * @PathVariable : 
	 * @PathVariable est une annotation Spring qui indique qu'un param�tre de m�thode doit �tre li� � une variable de la 
	 * requ�te (url)
	 */
	@GetMapping("/users/delete/{id}")
	public String deleteUser(Model model, @PathVariable Long id) {
		User user = service.getUser(id);
		if(user != null) {
			service.deleteUser(id);
		}
		return "redirect:/admin/users";
	}
	
	
	
	//Ajouter un utiliser 
		//Afficher le formulaire  (GET)
		//Soummettre le formulaire (POST)
	//Pour la validation : Mot cl� @Valid @ModelAttribute 
	
	//url ==> users/add
	

}
