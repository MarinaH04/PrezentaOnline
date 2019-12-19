package com.proiect.persistence.dao.impl;


import java.util.HashSet;
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

import com.commons.UserCursDTO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserType;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	public SessionFactory sessionFactory;
	
	public UserDAO userDAO;
	

	public void insera(String username, String firstname, String lastname, String email, String password, String tip) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUsername(username);
		user.setFirstname(firstname);
		user.setLastname(lastname);
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
	
	@SuppressWarnings("unchecked")
	public Set<Curs> getCourses(int uid){
		Session session = sessionFactory.openSession();
		Set<Curs> user_curs = new HashSet<>();
		Query q = session.createQuery("SELECT c FROM User u JOIN u.curs c WHERE u.user_id=:uid");
		q.setParameter("uid", uid);
		try {
			user_curs.addAll(q.list());
		} catch (Exception e) {
			System.out.println("Exception in get courses: "+ e.getMessage());
		}
		return user_curs;
	}
	
	
	public User login(String username, String password) {
		Session session = sessionFactory.openSession();
		User user_login = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		User userlogin = new User();
		if(user_login!=null) {
			
			if((user_login.getPassword()).equals(password)) {
				userlogin = user_login;
			}
			else System.out.println("Parola incorecta");
		}
		else System.out.println("Username inexistent");	
		
		return userlogin;
	}
	
	public void usercourse(String username) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unused")
		User usercurs = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		UserCursDTO userDTO = new UserCursDTO();
		userDTO.setUsername(username);
		Set<String> courses2 = new HashSet<String>();
		//Set<Curs> courses = new HashSet<Curs>();
//		for(Curs curs2:usercurs.getCurs()) {
//			courses2.add(curs2.getDenumire());
//		}
		userDTO.setCourses(courses2);
		
	}

}
