package com.proiect.business;

import java.util.List;

import com.commons.CursDTO;
import com.commons.UserCursDTO;
import com.commons.UserDTO;
import com.commons.UserTypeDTO;

public interface UserManager {
	public UserDTO getUser(String username);
	public List<UserDTO> getUsers();
	public CursDTO getCurs(String denumire);
	public UserCursDTO getUserCurs(String username);
	public UserDTO login(String username, String password);
	public UserTypeDTO getUserTypeDTO(String username);
}
