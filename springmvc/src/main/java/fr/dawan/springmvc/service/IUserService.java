package fr.dawan.springmvc.service;

import java.util.List;

import fr.dawan.springmvc.entities.User;

public interface IUserService {
	
	public void SaveAndUpdateUser(User user);
	public List<User> findAllUsers();
	public User getUserByPasswordAndEmail(String email, String password);
	public User getUser(Long id);
	public void deleteUser(Long id);
	
}
