package fr.dawan.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.springmvc.entities.User;

/*
 * @Repository  ==> Pour dire que c'est une classe qui doit être instanciée par Spring, 
 * Sinon Spring ne traitera pas cette classe au demarrage.
 * C'est un composant Spring qui est fait pour la couche DAO, pour le mapping Objet Relationnel
 */
@Repository
public class UserDaoImpl implements IUserDao{
	
	
	/*
	 * Pour gérer la gestion des entités on aura besoin de créer une variable entityManager 
	 * EntityManager c'est une interface. Donc on va demander à Spring de nous créer 
	 * un objet EntityManager en utilisant l'annotation @PersistenceContext, c'est à dire : 
	 * 		o Spring va créer l'objet EntityManagerFactory 
	 * 		o lit le fichier persistencee "persistence.xml"
	 * 		  qui va entrainter la création du data-source qui établira une connexion à la de données 
	 */
	@PersistenceContext
	private EntityManager entityManager;


	@Transactional
	@Override
	public void saveAndUpdate(User user) {
		if(user.getId() == null || user.getId() == 0 ) {
			entityManager.persist(user);
		} else {
			entityManager.merge(user);
		}		
	}

	/*
	 * Par defaut, les transaction Spring sont en lecture-ecriture 
	 * mais on peut configurer explicitement pour qu'elles soient 
	 * exécutées dans un context de lecture 
	 * 
	 * Le méthodes dont le nom commence par get sont en lecture seule, 
	 * les autres méthodes sont en lecture/ecriture qui le mode par defaut
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		
		/*
		 * Utiliser la méthode createQuery qui retourne un objet Query
		 */
		String sql = "SELECT u FROM User u";
		TypedQuery<User> query = entityManager.createQuery(sql, User.class);
		return query.getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public User findOn(Long id) {
		User user = entityManager.find(User.class, id);			
		return user;
	}

	@Transactional
	@Override
	public void delete(Long id) {
		User user = entityManager.find(User.class, id);
		if(user != null) {
			entityManager.remove(user);
		}
	}

	@Transactional(readOnly = true)
	@Override
	public User findUserByPasswordAndEmail(String email, String password) {
		
	/*
	 * Utiliser la méthode createQuery qui retourne un objet Query
	 * Avec cette objet appeler la methode setParameter
	 */
		String sql = "SELECT u FROM User u WHERE u.email=: email AND u.password=: password";
		Query query = entityManager.createQuery(sql);
		
		query.setParameter("email", email);
		query.setParameter("password", password);
		// TODO Auto-generated method stub
		return (User) query.getSingleResult();
	}
	
	
	


}
