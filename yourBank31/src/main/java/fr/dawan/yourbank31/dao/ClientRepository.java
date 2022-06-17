package fr.dawan.yourbank31.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.yourbank31.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
