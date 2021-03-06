package com.proiect.persistence.dao.impl;


import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Query;

import com.commons.PrezentaDTO;
import com.proiect.persistence.dao.PrezentaDAO;
import com.proiect.persistence.entity.Prezenta;
import com.proiect.persistence.entity.UserCurs;

@Repository
@Transactional
public class PrezentaDAOImpl implements PrezentaDAO {
	@Autowired
	public SessionFactory sessionFactory;
	public void insert(PrezentaDTO prezentaDTO) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserCurs usercurs = new UserCurs();
		Query q = session.createQuery("SELECT uc FROM UserCurs uc JOIN uc.user u JOIN uc.curs c WHERE u.username=:username AND c.denumire = :denumire");
		q.setParameter("username", prezentaDTO.getUsername());
		q.setParameter("denumire", prezentaDTO.getDenumire());
		usercurs = (UserCurs) q.uniqueResult();
		Integer uc_id = usercurs.getUc_id();
		System.out.println(uc_id);
		Prezenta prez = new Prezenta();
		prez.setUsercurs(usercurs);
		prez.setDate(prezentaDTO.getDate());
		prez.setPresent(prezentaDTO.getPresent());
		session.save(prez);
		tx.commit();
	}
	
	public Boolean display(String username, String denumire, Date date) {
		Session session = sessionFactory.openSession();
		UserCurs usercurs = new UserCurs();
		Query q = session.createQuery("SELECT uc FROM UserCurs uc JOIN uc.user u JOIN uc.curs c WHERE u.username=:username AND c.denumire = :denumire");
		q.setParameter("username", username);
		q.setParameter("denumire", denumire);
		usercurs = (UserCurs) q.uniqueResult();
		Query q1 = session.createQuery("Select p from Prezenta p WHERE p.usercurs = :usercurs AND p.date = :date");
		q1.setParameter("usercurs", usercurs);
		q1.setParameter("date", date);
		Prezenta prez = new Prezenta();
		try {
		prez = (Prezenta) q1.uniqueResult();
		System.out.println("Prezenta este: "+prez);
		System.out.println("data este" + date);
		Boolean b = prez.getPresent();
		return b;}
		catch(Exception ex) {
			return null;
		}
	}
}
