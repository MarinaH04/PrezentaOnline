package com.proiect.persistence.controller;

import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
	
	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	public void createUser(String str) {
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(str);
			String username = jsonObj.getString("username");
			String firstname = jsonObj.getString("firstname");
			String lastname = jsonObj.getString("lastname");
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");
			String tip = jsonObj.getString("tip");

			userDAO.insera(username,firstname,lastname, email, password, tip);
		}
		catch(JSONException e) {
			e.printStackTrace();
			}
	}
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void createUserCurs(String str) {
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(str);
			String username = jsonObj.getString("username");
			String denumire = jsonObj.getString("denumire");
			
			userDAO.update(username, denumire);
		}
		catch(JSONException e) {
			e.printStackTrace();
			}
	}
	
	@DELETE
	  @Path("{id}")
	public void deleteUser(@PathParam("id") int user_id) {
		userDAO.deleteUser(user_id);
	}
	
	
	
}
