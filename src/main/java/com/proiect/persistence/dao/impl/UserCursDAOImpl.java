package com.proiect.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import com.proiect.persistence.dao.UserCursDAO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserCurs;

@Repository
@Transactional
public class UserCursDAOImpl implements UserCursDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public void update(String username, String denumire) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		user = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		Curs curs = null;
		curs = (Curs) session.createCriteria(Curs.class).add(Restrictions.eq("denumire", denumire)).uniqueResult();
		Integer curs_id = curs.getCurs_id();
		Integer user_id = user.getUser_id();
		UserCurs usercurs = new UserCurs();
	}
}
