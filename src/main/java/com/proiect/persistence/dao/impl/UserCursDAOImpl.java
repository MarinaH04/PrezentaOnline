package com.proiect.persistence.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;

import com.commons.StudProfDTO;
import com.proiect.persistence.dao.UserCursDAO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserCurs;

@Repository
@Transactional
public class UserCursDAOImpl implements UserCursDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public void update(StudProfDTO studprof) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		user = (User) session.createCriteria(User.class).add(Restrictions.eq("username", studprof.getUsername())).uniqueResult();
		Curs curs = null;
		System.out.println(studprof.getDenumire());
		curs = (Curs) session.createCriteria(Curs.class).add(Restrictions.eq("denumire", studprof.getDenumire())).uniqueResult();
		System.out.println(curs);
		UserCurs usercurs = new UserCurs();
		List<UserCurs> result = null;
		try {

			result = session.createQuery("FROM UserCurs").list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		int i = 0;
		for(UserCurs result_uc: result) {
			if(result_uc.getUser().getUser_id() == user.getUser_id()) {
				if(result_uc.getCurs().getCurs_id() == curs.getCurs_id()) {
					System.out.println("User si curs deja existenti!!!");
					i++;
				}

			}
		}
		if(i==0) {
			usercurs.setUser(user);
			usercurs.setCurs(curs);
			session.save(usercurs);
			tx.commit();	
		}
		

	}
}
