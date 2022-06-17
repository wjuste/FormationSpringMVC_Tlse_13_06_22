package fr.dawan.yourbank31.service.exception;

public class SoldeInsuffisantException extends Exception {
	
	private String soldeInsuffisant;
	
	

	public SoldeInsuffisantException() {
		super();
	}



	public SoldeInsuffisantException(String soldeInsuffisant) {
		super();
		this.soldeInsuffisant = soldeInsuffisant;
	}



	public String getSoldeInsuffisant() {
		return soldeInsuffisant;
	}



	public void setSoldeInsuffisant(String soldeInsuffisant) {
		this.soldeInsuffisant = soldeInsuffisant;
	}
	
	

}
