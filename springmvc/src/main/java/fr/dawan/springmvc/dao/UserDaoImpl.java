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
 * @Repository  ==> Pour dire que c'est une classe qui doit �tre instanci�e par Spring, 
 * Sinon Spring ne traitera pas cette classe au demarrage.
 * C'est un composant Spring qui est fait pour la couche DAO, pour le mapping Objet Relationnel
 */
@Repository
public class UserDaoImpl implements IUserDao{
	
	
	/*
	 * Pour g�rer la gestion des entit�s on aura besoin de cr�er une variable entityManager 
	 * EntityManager c'est une interface. Donc on va demander � Spring de nous cr�er 
	 * un objet EntityManager en utilisant l'annotation @PersistenceContext, c'est � dire : 
	 * 		o Spring va cr�er l'objet EntityManagerFactory 
	 * 		o lit le fichier persistencee "persistence.xml"
	 * 		  qui va entrainter la cr�ation du data-source qui �tablira une connexion � la de donn�es 
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
	 * ex�cut�es dans un context de lecture 
	 * 
	 * Le m�thodes dont le nom commence par get sont en lecture seule, 
	 * les autres m�thodes sont en lecture/ecriture qui le mode par defaut
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		
		/*
		 * Utiliser la m�thode createQuery qui retourne un objet Query
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
	 * Utiliser la m�thode createQuery qui retourne un objet Query
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
