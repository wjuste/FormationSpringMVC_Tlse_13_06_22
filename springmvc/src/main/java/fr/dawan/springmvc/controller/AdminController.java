package fr.dawan.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.springmvc.entities.Role;
import fr.dawan.springmvc.entities.User;
import fr.dawan.springmvc.form.FormUser;
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
	 * @PathVariable est une annotation Spring qui indique qu'un paramètre de méthode doit être lié à une variable de la 
	 * requête (url)
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
	//Pour la validation : Mot clé @Valid @ModelAttribute 
	
	//url ==> users/add
	
	//Afficher le formulaire 
	@GetMapping("/users/add")
	public String addUser(Model model) {
		model.addAttribute("formuser", new FormUser());
		return "adduser";
	}
	
	
	/*
	 * @valid : C'est une annotation Spring 
	 * On va demander à Spring de valider, de verifier si cet objet est correcte 
	 * En même temps s'il y a des messages d'erreurs on les recupères dans un objet BindingResult 
	 * Ceci permet de récuperer les résultats de la validation dans un objet BindingResult 
	 * 
	 * Les champs sont récuperés dans un objet annotés @ModelAttribute 
	 * @ModelAttribute : Objet posté par un formulaire
	 * 
	 *Voir exemple page 129 pdf
	 */
	@PostMapping("/users/add")
	public ModelAndView addUser(@Valid @ModelAttribute("formuser") FormUser formuser, BindingResult result, Model model) {
		System.out.println(formuser);
		ModelAndView modelView = new ModelAndView();
		
		if(result.hasErrors())  {			//Si on ne respectent pas les annotations mises dans FormUser
			modelView.addObject("error", result);
			modelView.addObject("formuser", formuser);
			modelView.setViewName("adduser");
		} else {
			User u = new User(formuser.getPrenom(), formuser.getNom(), formuser.getEmail(), formuser.getPassword());
			//u.setRole(Role.USER);
			service.SaveAndUpdateUser(u);
			modelView.setViewName("redirect:/admin/users");
		}
		
		return modelView;
	}

}
