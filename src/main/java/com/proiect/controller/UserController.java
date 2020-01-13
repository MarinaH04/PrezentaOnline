package com.proiect.controller;

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
import com.commons.UserTypeDTO;
import com.proiect.business.UserManager;


@Path("/userDTO")
public class UserController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dto.xml");
	UserManager userManager = context.getBean(UserManager.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> getUseri() {
		return userManager.getUsers();
	}

	@GET
	@Path("{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getUs(@PathParam("username") String username) {
		return userManager.getUser(username);
	}
	
	@GET
	@Path("/byusertype/{tip}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> getUserByType(@PathParam("tip") String tip) {
		return userManager.getUsersByType(tip);
	}
	
	@GET
	@Path("/course/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserCursDTO getUserCurs(@PathParam("username") String username) {
		return userManager.getUserCurs(username);
	}

	@GET
	@Path("usertype/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserTypeDTO getUserTypes(@PathParam("username") String username) {
		return userManager.getUserTypeDTO(username);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO login(String str) {
		JSONObject jsonObj;
		String username = "";
		String password = "";

		try {
			jsonObj = new JSONObject(str);
			username = jsonObj.getString("username");
			password = jsonObj.getString("password");

		} catch (JSONException e) {
		}
		return userManager.login(username, password);

	}
	
	@POST
	@Path("/edit")
	@Produces(MediaType.APPLICATION_JSON)
	public void edit(String str) {
		JSONObject jsonObj;
		String username = "";
		String firstname = "";
		String lastname = "";
		String email = "";
		String password = "";
		
		try {
			jsonObj = new JSONObject(str);
			username = jsonObj.getString("username");
			firstname = jsonObj.getString("firstname");
			lastname = jsonObj.getString("lastname");
			email = jsonObj.getString("email");
			password = jsonObj.getString("password");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		userManager.editDTO(username, firstname, lastname, email, password);
	}

	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	public void inserted(String str) {
		JSONObject jsonObj;
		String username = "";
		String firstname = "";
		String lastname = "";
		String email = "";
		String password = "";
		String tip = "";
		try {
			jsonObj = new JSONObject(str);
			username = jsonObj.getString("username");
			firstname = jsonObj.getString("firstname");
			lastname = jsonObj.getString("lastname");
			email = jsonObj.getString("email");
			password = jsonObj.getString("password");
			tip = jsonObj.getString("tip");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		userManager.insertDTO(username, firstname, lastname, email, password, tip);
	}
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void createUserCurs(String str) {
		JSONObject jsonObj;
		String username="";
		String denumire="";
		try {
			jsonObj = new JSONObject(str);
			username = jsonObj.getString("username");
			denumire = jsonObj.getString("denumire");
			
			
		}
		catch(JSONException e) {
			e.printStackTrace();
			}
		userManager.updateDTO(username, denumire);
	}

}
