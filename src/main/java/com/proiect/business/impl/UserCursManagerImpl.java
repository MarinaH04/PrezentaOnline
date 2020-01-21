package com.proiect.business.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.StudProfDTO;
import com.proiect.business.UserCursManager;
import com.proiect.persistence.dao.UserCursDAO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;

public class UserCursManagerImpl implements UserCursManager {
	final ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
	UserDAO userDAO = appContext.getBean(UserDAO.class);
	UserCursDAO usercursDAO = appContext.getBean(UserCursDAO.class);
	
	public void updateDTO(String username, String denumire) {
		StudProfDTO studProf = new StudProfDTO();
		studProf.setUsername(username);
		User prof = userDAO.getUserByUsername(denumire);
		List<Curs> cursuriprof = userDAO.getCursUser(prof.getUsername());
		String curs = cursuriprof.toString();
		String[] arrOfStr = curs.split(",", 5);
		String cursprof = arrOfStr[1];
		cursprof = cursprof.substring(10, cursprof.length()-2);
		studProf.setDenumire(cursprof);
		usercursDAO.update(studProf);
	}

}
