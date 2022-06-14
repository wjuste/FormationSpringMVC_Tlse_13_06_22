package fr.dawan.springcore.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dawan.springcore.beans.Contact;

public class MainAnnotation {

	public static void main(String[] args) {
		
		ApplicationContext  context = new ClassPathXmlApplicationContext("confAnnotation.xml");
		Contact contact =  context.getBean("c1", Contact.class);
		System.out.println(contact);
		
	}

}
