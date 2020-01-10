package com.proiect.persistence.dao;

import java.util.List;
import java.util.Set;
import com.commons.UserInsertDTO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserType;


public interface UserDAO {
	
	public List<User> displayUsers();
	public List<User> displayStudents(String tip);
	public void deleteUser(Integer user_id);
	public User getUserByUsername(String username);
	public Set<Curs> getCourses(int uid);
	public User login(String username, String password);
	public void usercourse(String username);
	public UserType getUserType(String username);
	public void insert(UserInsertDTO userDTO);
}
