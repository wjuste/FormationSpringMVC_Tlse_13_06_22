package fr.dawan.yourbank31.service.exception;

public class VirementMemeCompteException extends Exception {
	
	private String VirementMemeCompteImpossible;
	
	

	public VirementMemeCompteException() {
		super();
	}



	public VirementMemeCompteException(String virementMemeCompteImpossible) {
		super();
		VirementMemeCompteImpossible = virementMemeCompteImpossible;
	}



	public String getVirementMemeCompteImpossible() {
		return VirementMemeCompteImpossible;
	}
	
	

}
