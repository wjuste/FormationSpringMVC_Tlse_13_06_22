package fr.dawan.tpioc.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import fr.dawan.tpioc.dao.IDao;
import fr.dawan.tpioc.service.IMetier;

public class Application2 {

	public static void main(String[] args) {

		try {
			Scanner input = new Scanner(new File("config.txt"));
			
			//Lire le nom de la classe dao 
			String daoClassName = input.next();
			
			//Lire le nom de la classe metier
			String metierClassName = input.next();
			
			System.out.println(daoClassName);
			System.out.println(metierClassName);
			
			/*
			 * Charge dynamiquement la classe en memoire (ici fr.dawan.tpioc.dao.DaoImpl)
			 * Et retourne une instance (un objet) de la classe representée (fr.dawan.tpioc.dao.DaoImpl)
			 */
			Class cDao =  Class.forName(daoClassName);
			
			
			/*
			 * Crée une nouvelle instance (un objet) de notre classe 
			 * et nous retourne l'objet crée (de type Object)
			 */
			IDao dao =  (IDao) cDao.newInstance();
			
			System.out.println(dao.getValue());
			
			
			Class cMetier = Class.forName(metierClassName);
			IMetier metier = (IMetier) cMetier.newInstance();
			
			/*
			 * getMethod prend une chaine de caractère qui est le nom de la méthode et 
			 * un deuxième paramètre qui sont les différents paramètres que la methodes 
			 * qui est ici IDao
			 */
			Method m1 = cMetier.getMethod("setDao", new Class[] {IDao.class});
			
			//Pour executer la méthode on fait appel à la methode invoke
			//invoke prend en premier paramètre l'instance que laquelle la méthode doit être 
			//invoquée (ici metier est l'instance)
			//Le deuxième paramètre sont les valeurs qui seront passées en paramètres lors de l'invocation
			//metier.setDao(dao)  ==> Injection de dependance (on injecte dao comme implementation)
			m1.invoke(metier, new Object[] {dao});
			
			System.out.println(metier.calcul());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
