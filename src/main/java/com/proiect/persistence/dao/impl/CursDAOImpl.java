package com.proiect.persistence.dao.impl;
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proiect.persistence.dao.CursDAO;
import com.proiect.persistence.entity.Curs;




@Repository
@Transactional
public class CursDAOImpl implements CursDAO{
	@Autowired
	public SessionFactory sessionFactory;
	public void saveObj(Object object) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.saveOrUpdate(object);
	    session.getTransaction().commit();
	    session.close();
	}
	public void insert(Integer curs_id, String denumire) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Curs curs = new Curs();
		curs.setCurs_id(curs_id);
		curs.setDenumire(denumire);
		
		session.save(curs);
		tx.commit();
		session.close();
	}


	
	@SuppressWarnings("unchecked")
	public List<Curs> displayCursuri(){
		Session session = this.sessionFactory.openSession();
		List<Curs> result = null;
		try {
		 result = session.createQuery("FROM Curs").list();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}
	
	public Curs getCursByDenumire(String denumire){
		 Session session = sessionFactory.openSession();
		 Curs curs = null;
		 curs = (Curs) session.createCriteria(Curs.class).add(Restrictions.eq("denumire", denumire)).uniqueResult();
	
		return curs;
	}

}
