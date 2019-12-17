package com.proiect.persistence.dao;

import java.util.List;
import java.util.Set;

import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;


public interface UserDAO {
	public void insera(String username, String email, String password, String tip);
	public List<User> displayUsers();
	public void deleteUser(Integer user_id);
	public User getUserByUsername(String username);
	public void saveObj(Object object);
	public void update(String username, String denumire);
	public Set<Curs> getCourses(int uid);
}
