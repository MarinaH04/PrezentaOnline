package com.proiect.business;

import com.commons.CursDTO;
import com.commons.CursUserDTO;

public interface CourseManager {
	public CursUserDTO getCursUser(String denumire);
	public CursDTO getCurs(String denumire);
}
