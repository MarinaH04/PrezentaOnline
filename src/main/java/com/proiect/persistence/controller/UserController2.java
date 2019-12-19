package com.proiect.persistence.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.UserCursDTO;
import com.commons.UserDTO;
import com.proiect.business.UserManager;


@Path("/userDTO")
public class UserController2 {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dto.xml");
		UserManager userManager = context.getBean(UserManager.class);
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<UserDTO> getUseri(){
			return userManager.getUsers();
		}
		@GET
		@Path("{username}")
		@Produces(MediaType.APPLICATION_JSON)
		public UserDTO getUs(@PathParam("username") String username) {
			return userManager.getUser(username);
		}
		
		@GET
		@Path("/course/{username}")
		@Produces(MediaType.APPLICATION_JSON)
		public UserCursDTO getUserCurs(@PathParam("username") String username) {
			return userManager.getUserCurs(username);
		}
		
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public UserDTO login(String str) {
			JSONObject jsonObj;
			String username="";
			String password="";
			
			try {
				jsonObj = new JSONObject(str);
				 username = jsonObj.getString("username");
				password = jsonObj.getString("password");
			
			}
			catch(JSONException e) {}
			return userManager.login(username, password);
			
		}
	
}
