package com.proiect.business;

import java.util.Date;

import com.commons.PrezentaDTO;

public interface PrezentaManager {
	public void insert(String username, String denumire, Boolean present, Date date);
	public PrezentaDTO present(String username, String denumire, Date date);
}
