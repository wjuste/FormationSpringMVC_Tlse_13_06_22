package fr.dawan.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.springmvc.dao.IUserDao;
import fr.dawan.springmvc.entities.User;

public class UserServiceImpl implements IUserService{
	
	@Autowired    //Injection de dependance 
	private IUserDao dao;//null
	
	
	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public void SaveAndUpdateUser(User user) {
		dao.saveAndUpdate(user);
	}

	@Override
	public List<User> findAllUsers() {
		return dao.findAll();
	}

	@Override
	public User getUserByPasswordAndEmail(String email, String password) {
		return dao.findUserByPasswordAndEmail(email, password);
	}

	@Override
	public User getUser(Long id) {
		return dao.findOn(id);
	}

	@Override
	public void deleteUser(Long id) {
		dao.delete(id);
	}
	
	
}
