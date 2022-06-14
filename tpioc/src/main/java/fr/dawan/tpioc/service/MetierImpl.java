package fr.dawan.tpioc.service;

import fr.dawan.tpioc.dao.IDao;

public class MetierImpl implements IMetier{

	private IDao dao; //null 
	
	public double calcul() {
		double temp = dao.getValue();
		return temp * 12;
	}

	
	//Injection de dependance se fera par le setter
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	

}
