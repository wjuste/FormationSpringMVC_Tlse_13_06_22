package fr.dawan.springcore.beans;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4430746029305015286L;
	
	private String prenom;
	private String nom; 
	
	@Autowired
//	@Qualifier("adr2")  //Quand il y a plusieurs bean on priorise (ex: adr2)
	//@Resource(name="adr2")  //Injection d'un bean par son nom
//	@Inject //equivalent en JavaEE de l'autowire en Spring 
//	@Named("adr2")   //equivalent à Qualifier en J2EE
	private Adresse adr; 

	public Contact() {
		super();
	}

	public Contact(String prenom, String nom, Adresse adr) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.adr = adr;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
	
	public void init() {
		System.out.println("Contact méthode init");
	}
	
	public void destroy() {
		System.out.println("Contact méthode destroy");
	}
	

	@Override
	public String toString() {
		return "Contact [prenom=" + prenom + ", nom=" + nom + ", adr=" + adr + "]";
	}  
	

}
