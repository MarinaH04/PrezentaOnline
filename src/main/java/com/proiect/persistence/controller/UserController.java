package com.proiect.persistence.controller;

import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proiect.persistence.dao.UserDAO;
import com.proiect.persistence.entity.User;

@Path("/user")
public class UserController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	UserDAO userDAO = context.getBean(UserDAO.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userDAO.displayUsers();
	}
	
	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUsers(@PathParam("username") String username){
		return userDAO.getUserByUsername(username);
	}
}
