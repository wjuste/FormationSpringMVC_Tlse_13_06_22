package fr.dawan.springmvc.dao;

import fr.dawan.springmvc.entities.User;

public interface IUserDao extends EntityRepository<User>{
	
	public User findUserByPasswordAndEmail(String email, String password);


}
