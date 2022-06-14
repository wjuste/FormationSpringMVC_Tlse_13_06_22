package fr.dawan.tpioc.presentation;

import fr.dawan.tpioc.dao.DaoImpl;
import fr.dawan.tpioc.dao.DaoImplV2;
import fr.dawan.tpioc.service.MetierImpl;

public class Application1 {

	public static void main(String[] args) {
		
		MetierImpl metier = new MetierImpl();
		
		//DaoImpl daoV1 = new DaoImpl();
		DaoImplV2 daoV2 = new DaoImplV2();
		
		//Injection de dependance 
		metier.setDao(daoV2);
		
		System.out.println(metier.calcul());
		
	}

}
