package com.proiect.persistence.dao;

import java.util.List;


import com.proiect.persistence.entity.Curs;

public interface CursDAO {
	
	
	public void insert(Integer curs_id, String denumire);
	public List<Curs> displayCursuri();
	public Curs getCursByDenumire(String denumire);

	public void saveObj(Object object);

}
