package fr.dawan.yourbank31.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.yourbank31.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	/* 
	 * On veut consulter les opérations d'un compte Page par Page
	 * On va declarer une page d'operation ==> Page<Operation> 
	 * 
	 * Avec une Spring data si on déclare une page 
	 * il faut retourner un objet de type Pageable
	 * 
	 * Il faut specifier avec l'annotation @Query la requête qu'on va executer 
	 * la liste des operations vont être trier par date du plus récent au moins récent
	 * Il faut specifier que numCpte correspond au paramètre x avec l'annotation @Param("x")
	 * 
	 * */
	@Query("select op from Operation op where op.compte.numCompte=:x order by op.numOperation desc")
	//Avec @Param on specifie que numCpte correspond au paramètre x
	Page<Operation> listOperation(@Param("x")String numCpte, Pageable pageable);
}
