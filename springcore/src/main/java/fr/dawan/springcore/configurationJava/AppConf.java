package fr.dawan.springcore.configurationJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import fr.dawan.springcore.beans.Adresse;
import fr.dawan.springcore.beans.Contact;
import fr.dawan.springcore.beans.Formation;

@Configuration
@ComponentScan(basePackages = "fr.dawan.springcore")  //Permet à Spring de savoir où trouver les beans
public class AppConf {
	
	//@Bean
	@Bean(name = {"formationExcel"})
	//@Scope("prototype")
	@Description("Une formation excel")
	public Formation formation1() {
		return new Formation();  
	}
	
	
	@Bean
	public Adresse adr() {
		return new Adresse("Rue ", " de Toulouse", "31300");
		
	}
	
	@Bean
	public Contact contact1(Adresse adr) {
		return new Contact("John", "Doe", adr);
	}

}
