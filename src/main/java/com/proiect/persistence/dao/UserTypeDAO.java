package com.proiect.persistence.dao;

import java.util.List;

import com.proiect.persistence.entity.UserType;

public interface UserTypeDAO {
	public void insert(String tip);
	public List<UserType> displayUsersType();
}
