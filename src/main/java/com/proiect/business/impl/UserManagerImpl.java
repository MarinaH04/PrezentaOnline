package com.proiect.business.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.CursDTO;
import com.commons.UserCursDTO;
import com.commons.UserDTO;
import com.commons.UserInsertDTO;
import com.commons.UserTypeDTO;
import com.proiect.business.UserManager;
import com.proiect.persistence.dao.CursDAO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.dao.UserTypeDAO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserType;


public class UserManagerImpl implements UserManager {
	
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	UserDAO userDAO = appContext.getBean(UserDAO.class);
	UserTypeDAO usertypeDAO = appContext.getBean(UserTypeDAO.class);
	CursDAO cursDAO = appContext.getBean(CursDAO.class);
	
	
	
	public UserDTO getUser(String username) {
		
		UserDTO userDTO = new UserDTO();
		User user1 = userDAO.getUserByUsername(username);
		userDTO.setFirstname(user1.getFirstname());
		userDTO.setLastname(user1.getLastname());
		userDTO.setUsername(username);
		userDTO.setEmail(user1.getEmail());
		return userDTO;
	}
	
	public List<UserDTO> getUsers(){
		List<User> users = userDAO.displayUsers();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(User user1:users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(user1.getUsername());
			userDTO.setFirstname(user1.getFirstname());
			userDTO.setLastname(user1.getLastname());
			userDTO.setEmail(user1.getEmail());
			usersDTO.add(userDTO);
		}
		return usersDTO;
	}
	
	public CursDTO getCurs(String denumire){
		Curs curs = cursDAO.getCursByDenumire(denumire);
		CursDTO cursDTO = new CursDTO();
		cursDTO.setDenumire(curs.getDenumire());
		return cursDTO;
	}
	
	public UserCursDTO getUserCurs(String username) {
		UserCursDTO usercurs = new UserCursDTO();
		User user_username = userDAO.getUserByUsername(username);
		usercurs.setUsername(user_username.getUsername());
		Integer user_id = user_username.getUser_id();
		Set<String> coursesDTO = new HashSet<String>();
		Set<Curs> courses = userDAO.getCourses(user_id);
		for(Curs curs1:courses) {
			String cursDTO = "";
			cursDTO = curs1.getDenumire();
			coursesDTO.add(cursDTO);
		}
		usercurs.setCourses(coursesDTO);
		return usercurs;
	}
	
	public UserDTO login(String username, String password) {
		UserDTO userDTO = new UserDTO();
		User user_login = userDAO.login(username, password);
		userDTO.setUsername(user_login.getUsername());
		userDTO.setFirstname(user_login.getFirstname());
		userDTO.setLastname(user_login.getLastname());
		userDTO.setEmail(user_login.getEmail());
		return userDTO;
	}
	
	public UserTypeDTO getUserTypeDTO(String username) {
		UserTypeDTO usert = new UserTypeDTO();
		UserType userType = userDAO.getUserType(username);
		usert.setUsername(username);
		usert.setTip(userType.getTip());
		return usert;
		
	}
	public void insertDTO(String username, String firstname, String lastname, String email, String password, String tip) {
		UserInsertDTO usert = new UserInsertDTO();
		usert.setUsername(username);
		usert.setFirstname(firstname);
		usert.setLastname(lastname);
		usert.setEmail(email);
		usert.setPassword(password);
		usert.setTip(tip);
		userDAO.insert(usert);
		
	}
}
