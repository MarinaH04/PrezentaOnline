package com.proiect.business;

import java.util.List;

import com.commons.UserCursDTO;
import com.commons.UserDTO;
import com.commons.UserTypeDTO;

public interface UserManager {
	public UserDTO getUser(String username);
	public List<UserDTO> getUsers();
	public List<UserDTO> getUsersByType(String tip);
	public UserCursDTO getUserCurs(String username);
	public UserDTO login(String username, String password);
	public UserTypeDTO getUserTypeDTO(String username);
	public void insertDTO(String username, String firstname, String lastname, String email, String password, String tip);
	public void editDTO(String username, String firstname, String lastname, String email, String password);
	public void deleteDTO(String username);
}
