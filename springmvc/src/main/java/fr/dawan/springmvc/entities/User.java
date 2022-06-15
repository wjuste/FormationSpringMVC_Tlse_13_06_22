package fr.dawan.springmvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;


@Entity
public class User extends AbstractEntity{

	private static final long serialVersionUID = -7377344588313275242L;

	private String prenom; 
	private String nom;
	private String email;
	private String password; 
	private Role role;
	

	public User() {
		super();
		role = Role.USER;
	}


	public User(String prenom, String nom, String email, String password) {
		this(); 
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	

}
