package com.proiect.persistence.dao.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Query;

import com.proiect.persistence.dao.PrezentaDAO;
import com.proiect.persistence.entity.Prezenta;
import com.proiect.persistence.entity.UserCurs;

@Repository
@Transactional
public class PrezentaDAOImpl implements PrezentaDAO {
	@Autowired
	public SessionFactory sessionFactory;
	public void insert(String username, String denumire, Date date, Boolean presence) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserCurs usercurs = new UserCurs();
		Query q = session.createQuery("SELECT uc FROM UserCurs uc JOIN uc.user u JOIN uc.curs c WHERE u.username=:username AND c.denumire = :denumire");
		q.setParameter("username", username);
		q.setParameter("denumire", denumire);
		usercurs = (UserCurs) q.uniqueResult();
		Integer uc_id = usercurs.getUc_id();
		System.out.println(uc_id);
		Prezenta prez = new Prezenta();
		prez.setUsercurs(usercurs);
		prez.setDate(date);
		prez.setPresent(presence);
		session.save(prez);
		tx.commit();
	}
}
