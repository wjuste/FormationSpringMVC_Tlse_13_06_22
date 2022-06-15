package fr.dawan.springcore.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dawan.springcore.beans.Contact;
import fr.dawan.springcore.beans.Formation;
import fr.dawan.springcore.beans.Stagiaire;

public class MainXML {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Formation f1 = context.getBean("formationExcel", Formation.class);
		System.out.println(f1);		
		
		/*
		 * Un bean à une portée Singleton par defaut
		 */
		Formation f2 = context.getBean("formation2", Formation.class);
		System.out.println(f2);
		Formation f3 = context.getBean("formation2", Formation.class);
		System.out.println(f3);
		
		/*
		 * Fournir la reference d'un bean
		 */
		Contact c1 = context.getBean("contact1", Contact.class);
		System.out.println(c1);
		
		Contact c3 = context.getBean("contact3", Contact.class);
		System.out.println("Avec Autowire byType Contact : " + c3);
		
		Contact c4 = context.getBean("contact4", Contact.class);
		System.out.println("Avec autowired constructor Contact : " + c4);
		
		Stagiaire stagiaire = context.getBean("stagiaire1", Stagiaire.class);
		System.out.println(stagiaire);
				
				
		((AbstractApplicationContext) context).close();   //Permet d'appeler la méthode destroy
	}

}
