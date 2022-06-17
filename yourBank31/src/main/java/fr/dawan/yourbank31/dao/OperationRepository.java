package fr.dawan.yourbank31.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.yourbank31.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	
}
