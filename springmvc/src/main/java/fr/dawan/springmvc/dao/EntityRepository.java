package fr.dawan.springmvc.dao;

import java.util.List;

import fr.dawan.springmvc.entities.AbstractEntity;
import fr.dawan.springmvc.entities.User;

/*
 * Interface g�nerique c'est une interface qu'on pourra utiliser pour n'importe quelle entit�
 */
public interface EntityRepository<T extends AbstractEntity> {
	
	public void saveAndUpdate(T t); 
	public List<T> findAll();
	public T findOn(Long id);
	public void delete(Long id);
	
	
}
