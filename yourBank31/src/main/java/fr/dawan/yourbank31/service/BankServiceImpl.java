package fr.dawan.yourbank31.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.yourbank31.dao.CompteRepository;
import fr.dawan.yourbank31.dao.OperationRepository;
import fr.dawan.yourbank31.entities.Compte;
import fr.dawan.yourbank31.entities.CompteCourant;
import fr.dawan.yourbank31.entities.Operation;
import fr.dawan.yourbank31.entities.Retrait;
import fr.dawan.yourbank31.entities.Versement;
import fr.dawan.yourbank31.service.exception.CompteIntrouvableException;
import fr.dawan.yourbank31.service.exception.SoldeInsuffisantException;
import fr.dawan.yourbank31.service.exception.VirementMemeCompteException;

@Service
@Transactional
public class BankServiceImpl implements IBankService{

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(String numCompte) throws CompteIntrouvableException {
		
		/*
		 * 1- compteRepository.findById(numCompte).get()  ==> On le recupère si il existe
		 * 2-Mais on peut utiliser compteRepository.findById(numCompte).orElse(null) 
		 * 		Il cherche le compte. S'il existe pas il retourne null 
		 * 		S'il est à null c'est une exception qu'il faudra generer
		 */
		Compte cb = compteRepository.findById(numCompte).orElse(null);
		
		if(cb == null) {
			throw new CompteIntrouvableException("Compte introuvable");
		}
		
		return cb;
	}

	@Override
	public void verser(String numCpte, double montant) throws CompteIntrouvableException {
		//Pour faire le versement il faut d'abord consulter 
		Compte cb = this.consulterCompte(numCpte);
		
		//Ensuite il faut réer un versement 
		Versement versement = new Versement(LocalDate.now(), montant, cb);
		
		//On enregistre l'operation de versement
		operationRepository.save(versement);
		
		//On met à jour le solde 
		cb.setSolde(cb.getSolde() + montant);
		
		compteRepository.save(cb);
	}

	@Override
	public void retirer(String numCompte, double montant) throws CompteIntrouvableException, SoldeInsuffisantException {
		
		Compte cb = this.consulterCompte(numCompte);
		
		double decouvert = 0; 
		
		if(cb instanceof CompteCourant) {  //Si c'est un compte courant
			decouvert = ((CompteCourant) cb).getDecouvert();  //On recupere le decouvert du compte
		}
		
		if(cb.getSolde() + decouvert < montant) {
			throw new SoldeInsuffisantException("Solde insuffisant");
		}
		
		//On crée l'operation de Retrait 
		Retrait retrait = new Retrait(LocalDate.now(), montant, cb);
		
		//On enregistre l'operation de retrait 
		operationRepository.save(retrait);
		
		//On met à jour le solde 
		
		cb.setSolde(cb.getSolde() - montant);
		
		compteRepository.save(cb);
	}

	@Override
	public void virement(String numCompte1, String numCompte2, double montant) throws VirementMemeCompteException, CompteIntrouvableException, SoldeInsuffisantException {
		
		//Permet de ne pas effectuer un virement sur un même compte 
		if(numCompte1.equals(numCompte2)) {
			throw new VirementMemeCompteException("Impossible d'effectuer un virement sur le même compte");
		}
		
		this.retirer(numCompte1, montant);
		this.verser(numCompte2, montant);
		
	}
	
	
	@Override
	public Page<Operation> listOperation(String numCpte, int page, int size) {
		
		//PageRequest est une implementation de  l'interface Pageable	
		return operationRepository.listOperation(numCpte, PageRequest.of(page, size));
			
	}
}
