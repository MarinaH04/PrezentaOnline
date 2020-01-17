package com.proiect.controller;

import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commons.PrezentaDTO;
import com.proiect.business.PrezentaManager;
import com.proiect.business.impl.DateParser;


@Path("/prezentaDTO")
public class PrezentaController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dto.xml");
	PrezentaManager prezManager = context.getBean(PrezentaManager.class);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void prezinsert(String str) {
		JSONObject jsonObj;
		String username = "";
		String denumire="";
		String dataString ="";
		Date date=null;
		Boolean present=null;
		
//		String dataString = DateParser.toString(date);
		try {
			jsonObj = new JSONObject(str);
			username = jsonObj.getString("username");
			denumire =jsonObj.getString("denumire");
			dataString = jsonObj.getString("date");
			present = jsonObj.getBoolean("present");
			date = DateParser.parse(dataString);
		} catch (Exception e) {
		}
		
		prezManager.insert(username, denumire, present, date);
	}
	
	@POST
	@Path("/presence")
	@Produces(MediaType.APPLICATION_JSON)
	public PrezentaDTO presence(String str) {
		JSONObject jsonObj;
		String username = "";
		String denumire="";
		String dataString ="";
		Date date=null;
		
		try {
			jsonObj = new JSONObject(str);
			username = jsonObj.getString("username");
			denumire =jsonObj.getString("denumire");
			dataString = jsonObj.getString("date");
			date = DateParser.parse(dataString);
			System.out.println(date);
		}
		catch (Exception e) {
		}
		return prezManager.present(username, denumire, date);
	}
	
}
