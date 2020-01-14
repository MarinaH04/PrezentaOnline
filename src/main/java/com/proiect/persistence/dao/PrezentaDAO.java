package com.proiect.persistence.dao;

import java.util.Date;

public interface PrezentaDAO {
	public void insert(String username, String denumire, Date date, Boolean presence);
}
