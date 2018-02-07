package com.example.abstraction.controller;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.abstraction.service.CommService;

@RestController
@RequestMapping("/communicate")
public class CommController {
	
	@Autowired
	private CommService service;
	
	private Date deploymentTime;
	
	@PostConstruct
	public void setDeploymentTime(){
		deploymentTime = Calendar.getInstance().getTime();
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/vnd.baeldung.api.v1+json")
	@ResponseBody
	public String test() {
		JSONObject testJson = new JSONObject();	
		testJson.put("component", "Communicatio nmodule");
		testJson.put("deployed on", deploymentTime.toString());
		return testJson.toString();
	}
	
	
}
