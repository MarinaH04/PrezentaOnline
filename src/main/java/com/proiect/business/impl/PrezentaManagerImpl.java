package com.proiect.business.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.PrezentaDTO;
import com.proiect.business.PrezentaManager;
import com.proiect.persistence.dao.CursDAO;
import com.proiect.persistence.dao.PrezentaDAO;
import com.proiect.persistence.dao.UserCursDAO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.dao.UserTypeDAO;

public class PrezentaManagerImpl implements PrezentaManager{
	
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	UserDAO userDAO = appContext.getBean(UserDAO.class);
	UserTypeDAO usertypeDAO = appContext.getBean(UserTypeDAO.class);
	CursDAO cursDAO = appContext.getBean(CursDAO.class);
	UserCursDAO usercursDAO = appContext.getBean(UserCursDAO.class);
	PrezentaDAO prezentaDAO = appContext.getBean(PrezentaDAO.class);
	
	public void insert(String username, String denumire, Boolean present, Date date) {
		PrezentaDTO prezentaDTO = new PrezentaDTO();
		prezentaDTO.setUsername(username);
		prezentaDTO.setDenumire(denumire);
		prezentaDTO.setDate(date);
		prezentaDTO.setPresent(present);
		prezentaDAO.insert(prezentaDTO);
	}
	
	public PrezentaDTO present(String username, String denumire, Date date) {
		Boolean b = prezentaDAO.display(username, denumire, date);
		PrezentaDTO prezDTO = new PrezentaDTO();
		prezDTO.setUsername(username);
		prezDTO.setDenumire(denumire);
		prezDTO.setDate(date);
		prezDTO.setPresent(b);
		return prezDTO;
	}
}
