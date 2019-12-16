package com.proiect.persistence.dao.impl;


import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Query;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserType;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	public SessionFactory sessionFactory;

	public void insera(String username, String email, String password, String tip) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		UserType usert = null;
		Query q = sessionFactory.getCurrentSession().createQuery("FROM UserType WHERE tip=:tip");
		q.setParameter("tip", tip);
		usert = (UserType) q.uniqueResult();
		if (usert != null) {
			user.setUserType(usert);
			session.save(user);
			tx.commit();
		}
		session.close();
	}

	public void update(String username, String denumire) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		user = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		Curs cursuri = null;
		 cursuri = (Curs) session.createCriteria(Curs.class).add(Restrictions.eq("denumire", denumire)).uniqueResult();
		Set<Curs> s = user.getCurs();
		s.add(cursuri);
		user.setCurs(s);
		//session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<User> displayUsers() {
		Session session = this.sessionFactory.openSession();
		List<User> result = null;
		try {

			result = session.createQuery("FROM User").list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}

	public User getUserByUsername(String username) {
		Session session = sessionFactory.openSession();
		User user = null;
		user = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		return user;

	}

	public void deleteUser(Integer user_id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.load(User.class, user_id);

		session.delete(user);

		session.getTransaction().commit();

		System.out.println("Deleted Successfully");
	}

	public void saveObj(Object object) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(object);
		session.getTransaction().commit();
		session.close();
	}

}
