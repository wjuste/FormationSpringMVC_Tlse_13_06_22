package fr.dawan.springmvc.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//Pour la validation des formulaires ===> Ajouter dependance : hibernate-validator
public class FormUser {
	
	/*
	 * nom ne doit pas être null 
	 * et doit être compris entre 1 et 40 
	 */
	@NotNull
	@Size(min=1, max=40)
	private String nom;
	
	@NotNull
	@Size(min=1, max=40)
	private String prenom;
	
	@NotNull
	@Size(min=8, max=40)
	private String password;
	
	//abcd45@gmail.com
	/*
	 * {3} : de 1 à 3 fois
	 * {1,} : au moins 1 fois
	 */
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{1,}[@]{1}[a-z]{5,}[.]{1}+[a-z]{3}+$", message="l'email n'est pas valide")
	private String email;
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
