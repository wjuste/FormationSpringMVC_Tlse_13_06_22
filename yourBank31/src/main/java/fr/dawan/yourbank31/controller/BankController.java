package fr.dawan.yourbank31.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.yourbank31.entities.Compte;
import fr.dawan.yourbank31.service.IBankService;
import fr.dawan.yourbank31.service.exception.CompteIntrouvableException;

@Controller
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private IBankService bankService;
	
	@GetMapping("/operations")
	public String index() {
		return "comptes";
	}
	
	@GetMapping("/consultercompte")
	public String consulterCompte(Model model, String numCompte) {
		Compte cb;
		try {
			cb = bankService.consulterCompte(numCompte);
			model.addAttribute("compte", cb);
		} catch (CompteIntrouvableException e) {
			model.addAttribute("compteIntrouvableException", e.getCompteIntrouvable());
		}
		return "comptes";
	}

}
