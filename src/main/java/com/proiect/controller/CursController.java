package com.proiect.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.CursDTO;
import com.proiect.business.UserManager;


@Path("/course")
public class CursController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dto.xml");
	UserManager userManag = context.getBean(UserManager.class);
	
	@GET
	@Path("/{denumire}")
	@Produces(MediaType.APPLICATION_JSON)
	public CursDTO getCurs(@PathParam("denumire") String denumire){
		return userManag.getCurs(denumire);
	}
}
