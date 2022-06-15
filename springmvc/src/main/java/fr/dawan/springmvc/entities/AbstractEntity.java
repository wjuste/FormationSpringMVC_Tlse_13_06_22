package fr.dawan.springmvc.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass  //indique que la classe n'est pas une entité JPA mais ses champs seront enregistré en base
public class AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = -1252134146428682631L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * @Version permet de detecter des modifications simultanées sur la même ligne de table 
	 * 
	 * L'élément @Version indique que la table contient des enregistrement versionnés
	 * La propriéré est incréments automatiquement par Hibernate 
	 * 
	 * A chaque fois qu'il y aura une modification de cet objet, 
	 * la version de cet objet sera incrementé de 1 dans la table
	 */
	@Version
	private int version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
