package fr.dawan.springcore.beans;

import java.io.Serializable;

public class Adresse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 817161611986981825L;
	
	private String rue; 
	private String ville; 
	private String codePostal;
	
	public Adresse() {
		super();
	}

	public Adresse(String rue, String ville, String codePostal) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}
	

}
