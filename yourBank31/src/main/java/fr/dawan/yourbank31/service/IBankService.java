package fr.dawan.yourbank31.service;

import org.springframework.data.domain.Page;

import fr.dawan.yourbank31.entities.Compte;
import fr.dawan.yourbank31.entities.Operation;
import fr.dawan.yourbank31.service.exception.CompteIntrouvableException;
import fr.dawan.yourbank31.service.exception.SoldeInsuffisantException;
import fr.dawan.yourbank31.service.exception.VirementMemeCompteException;

public interface IBankService {
	
	public Compte consulterCompte(String numCompte) throws CompteIntrouvableException;
	public void verser(String numCpte, double montant) throws CompteIntrouvableException;
	public void retirer(String numCompte, double montant) throws CompteIntrouvableException, SoldeInsuffisantException;
	public void virement(String numCompte1, String numCompte2, double montant) throws VirementMemeCompteException, CompteIntrouvableException, SoldeInsuffisantException;
	
	public Page<Operation> listOperation(String codeCpte, int page, int size);


}
