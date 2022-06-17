package fr.dawan.yourbank31.service.exception;

public class CompteIntrouvableException extends Exception {
	
	private String compteIntrouvable;
	
	

	public CompteIntrouvableException() {
		super();
	}



	public CompteIntrouvableException(String compteIntrouvable) {
		super();
		this.compteIntrouvable = compteIntrouvable;
	}



	public String getCompteIntrouvable() {
		return compteIntrouvable;
	}
	
	

}
