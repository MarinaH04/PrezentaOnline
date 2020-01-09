package com.proiect.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proiect.persistence.dao.UserCursDAO;

@Repository
@Transactional
public class UserCursDAOImpl implements UserCursDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
}
