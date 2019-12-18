package com.proiect.business.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.commons.UserDTO;
import com.proiect.business.UserManager;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.entity.User;


public class UserManagerImpl implements UserManager {
	
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	UserDAO userDAO = appContext.getBean(UserDAO.class);
	
	
	
	public UserDTO getUsers(String username) {
		
		UserDTO userDTO = new UserDTO();
		User user1 = userDAO.getUserByUsername(username);
		userDTO.setFirstname(user1.getFirstname());
		userDTO.setLastname(user1.getLastname());
		userDTO.setUsername(username);
		return userDTO;
	}
}
