package com.proiect.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proiect.persistence.dao.UserTypeDAO;
import com.proiect.persistence.entity.UserType;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserTypeDAOImpl implements UserTypeDAO {
	@Autowired
	public SessionFactory sessionFactory;
	public void insert(String tip) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserType userType = new UserType();
		userType.setTip(tip);
		session.save(userType);
		tx.commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	public List<UserType> displayUsersType(){
		Session session = sessionFactory.openSession();
		List<UserType> result = null;
		try {
		 result = session.createQuery("FROM UserType").list();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}
}
