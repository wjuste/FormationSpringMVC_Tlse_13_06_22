package fr.dawan.springcore.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.dawan.springcore.beans.Formation;
import fr.dawan.springcore.configurationJava.AppConf;

public class MainJavaConfiguration {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);
		
//		Formation f1 = context.getBean("formation1", Formation.class);
//		System.out.println(f1);
		
		Formation f2 = context.getBean("formationExcel", Formation.class);
		System.out.println(f2);
		
		Formation f3 = context.getBean("formationExcel", Formation.class);
		System.out.println(f3);
		
	}

}
