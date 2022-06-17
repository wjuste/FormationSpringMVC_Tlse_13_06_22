package fr.dawan.yourbank31.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.yourbank31.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
