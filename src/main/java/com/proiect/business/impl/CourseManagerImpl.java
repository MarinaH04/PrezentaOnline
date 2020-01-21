package com.proiect.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.CursDTO;
import com.commons.CursUserDTO;
import com.proiect.business.CourseManager;
import com.proiect.persistence.dao.CursDAO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;

public class CourseManagerImpl implements CourseManager {
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	CursDAO cursDAO = appContext.getBean(CursDAO.class);
	
	public CursDTO getCurs(String denumire){	
		Curs curs = cursDAO.getCursByDenumire(denumire);
		CursDTO cursDTO = new CursDTO();
		cursDTO.setDenumire(curs.getDenumire());
		return cursDTO;
	}
	
	
	public CursUserDTO getCursUser(String denumire) {
		
		CursUserDTO cursuser = new CursUserDTO();
		Curs curs = cursDAO.getCursByDenumire(denumire);
		cursuser.setDenumire(curs.getDenumire());
		List<String> usersDTO = new ArrayList<String>();
		List<User> users = cursDAO.getUsersbyCourse(denumire);
		for(User user1:users) {
			String userDTO="";
			userDTO = user1.getUsername();
			usersDTO.add(userDTO);
		}
		cursuser.setUsers(usersDTO);
		return cursuser;
	}
}
