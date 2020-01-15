package com.proiect.persistence.dao;


import java.util.Date;

import com.commons.PrezentaDTO;

public interface PrezentaDAO {
	public void insert(PrezentaDTO prezentaDTO);
	public Boolean display(String username, String denumire, Date date);
}
