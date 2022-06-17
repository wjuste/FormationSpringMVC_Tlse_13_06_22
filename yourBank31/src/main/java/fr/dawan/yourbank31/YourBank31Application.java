package fr.dawan.yourbank31;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.dawan.yourbank31.dao.ClientRepository;
import fr.dawan.yourbank31.dao.CompteRepository;
import fr.dawan.yourbank31.dao.OperationRepository;
import fr.dawan.yourbank31.entities.Client;
import fr.dawan.yourbank31.entities.Compte;
import fr.dawan.yourbank31.entities.CompteCourant;
import fr.dawan.yourbank31.entities.CompteEpargne;
import fr.dawan.yourbank31.entities.Retrait;
import fr.dawan.yourbank31.entities.Versement;
import fr.dawan.yourbank31.service.IBankService;

/*
 * En implementant mon application avec CommandLineRunner
 * Elle nous oblige à redefinir une méthode run. 
 * Quand Spring Boot termine de demarrer, il appelle la méthode run. 
 * Les tests on les fera dans la méthode run
 */
@SpringBootApplication
public class YourBank31Application implements CommandLineRunner{

	/*
	 * L'injection de dependance se fera avec l'annotation Autowired
	 */
	@Autowired
	private ClientRepository clientRepository; 
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	//Test de la couche Service
	@Autowired
	IBankService bankService;
	
	public static void main(String[] args) {
		SpringApplication.run(YourBank31Application.class, args);
	}

	
	//Methode pour les tests
	@Override
	public void run(String... args) throws Exception {
	//	System.out.println("************Je suis ici ********");
	
	//La méthode save retourne le client crée
	//Après création des clients redemarrer l'application pour tester si les clients ont bien 
	//été crées
	Client c1 = clientRepository.save(new Client("Matheo", "matheo@gmail.com"));
	Client c2 = clientRepository.save(new Client("Louis", "louis@gmail.com"));
	
	//On va ajouter un compte qui appartient à un client
	Compte cb1 = compteRepository.save(new CompteCourant("c1", LocalDate.now(), 300000, c1, 2000));		
	Compte cb2 = compteRepository.save(new CompteEpargne("c2", LocalDate.now(), 7000, c2, 5.5));
	
	//On va créer les operation sur ces comptes 
	operationRepository.save(new Versement(LocalDate.now(), 72000, cb1));
	operationRepository.save(new Versement(LocalDate.now(), 28000, cb1)); 
	operationRepository.save(new Retrait(LocalDate.now(), 30000, cb1));  
	
	operationRepository.save(new Versement(LocalDate.now(), 1500, cb2)); 
	operationRepository.save(new Retrait(LocalDate.now(), 1000, cb2)); 
	
	
	//Test de la couche de service
	bankService.verser("c1", 100000);
			
	}

}
