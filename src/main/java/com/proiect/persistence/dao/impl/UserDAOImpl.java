package com.proiect.persistence.dao.impl;


import java.util.ArrayList;
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
import com.commons.UserDTO;
import com.commons.UserInsertDTO;
import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.entity.Curs;
import com.proiect.persistence.entity.User;
import com.proiect.persistence.entity.UserCurs;
import com.proiect.persistence.entity.UserType;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	public SessionFactory sessionFactory;
	
	public UserDAO userDAO;
	
	public void insert(UserInsertDTO userDTO) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		String username = userDTO.getUsername();
		user.setUsername(userDTO.getUsername());
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		Query q1 = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username");
		q1.setParameter("username", username);
		List<User> result = null;
		try {

			result.addAll(q1.list());
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(result);
		UserType usert = null;
		Query q = sessionFactory.getCurrentSession().createQuery("FROM UserType WHERE tip=:tip");
		q.setParameter("tip", userDTO.getTip());
		usert = (UserType) q.uniqueResult();
		if (usert != null && result == null) {
			user.setUserType(usert);
			session.save(user);
			tx.commit();
		}
		session.close();
	}

	
	
	public void edit(UserDTO userDTO) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		user = (User) session.createCriteria(User.class).add(Restrictions.eq("username", userDTO.getUsername())).uniqueResult();
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		session.update(user);
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
	@SuppressWarnings("unchecked")
	public List<User> displayStudents(String tip){
		Session session = this.sessionFactory.openSession();
		List<User> result = new ArrayList<User>();
		Query q = session.createQuery("SELECT u FROM User u JOIN u.userType t where t.tip=:tip");
		q.setParameter("tip", tip);
		try {
			result.addAll(q.list());
		} catch (Exception e) {
		}
		return result;
	}

	public User getUserByUsername(String username) {
		Session session = sessionFactory.openSession();
		User user = null;
		user = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		return user;

	}
	

	@SuppressWarnings("unchecked")
	public void deleteUser(UserDTO userDTO) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String username = userDTO.getUsername();
		User user = null;
		user = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		Query q = session.createQuery("Select uc FROM UserCurs uc JOIN uc.user u WHERE u.username=:username");
		q.setParameter("username", username);
		List<UserCurs> uc = new ArrayList<UserCurs>();
		try {
			uc.addAll(q.list());
		} catch (Exception e) {
		}
		for(UserCurs usercurs:uc) {
			session.delete(usercurs);
		}
		
		session.delete(user);
		session.getTransaction().commit();

		

		System.out.println("Deleted Successfully");
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

	@SuppressWarnings("unchecked")
	public List<Curs> getCursUser(String username){
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("SELECT c FROM UserCurs uc, Curs c INNER JOIN uc.user u INNER JOIN uc.curs ucc WHERE ucc=c and u.username=:username");
		q.setParameter("username", username);
		List<Curs> courseuser = new ArrayList<Curs>();
		try {
			courseuser.addAll(q.list());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return courseuser;
		
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
//		userDTO.setCourses(courses2);
		
	}
	public UserType getUserType(String username) {
		Session session = sessionFactory.openSession();
		UserType usert = null;
		Query q = session.createQuery("SELECT t FROM User u JOIN u.userType t where u.username=:username");
		q.setParameter("username", username);
		usert = (UserType) q.uniqueResult();
		return usert;
	}
}
