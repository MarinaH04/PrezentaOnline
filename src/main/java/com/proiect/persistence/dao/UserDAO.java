package com.proiect.persistence.dao;

import java.util.List;

import com.commons.UserDTO;
import com.commons.UserInsertDTO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserType;


public interface UserDAO {
	
	public List<User> displayUsers();
	public List<User> displayStudents(String tip);
	public void deleteUser(UserDTO userDTO);
	public User getUserByUsername(String username);
	public User login(String username, String password);
	public UserType getUserType(String username);
	public void insert(UserInsertDTO userDTO);
	public void edit(UserDTO userDTO);
	public List<Curs> getCursUser(String username);
}
