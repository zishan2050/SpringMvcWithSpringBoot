package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.db.OffenceType;
import com.demo.model.CalculationHelper;
import com.demo.model.OffenceHelper;
import com.google.gson.JsonObject;

@Controller
public class HomeController {
	
	@Autowired private OffenceHelper offenceHelper;
	@Autowired private CalculationHelper calculateHelper;
	
	@RequestMapping(method=RequestMethod.GET, value={"/home","/"})
	public String home(){
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/offence")
	@ResponseBody
	public List<OffenceType> getOffenceType(){
		return offenceHelper.getAllOffence();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/calculate")
	@ResponseBody
	public String calculate(@RequestParam(name="studentName", required=true) String studentName,
			@RequestParam(name="timeType", required=true) String timeType,
			@RequestParam(name="calculationType", required=true) String calculationType,
			@RequestParam(name="offences", required=true) List<OffenceType> offences){
		Integer totalDetentionPeriod = calculateHelper.getDetentionPeriodOfStudent(studentName, offences, timeType, calculationType);
		
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.addProperty("calculatedTime", totalDetentionPeriod);
		return jsonResponse.toString();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addOffence")
	@ResponseBody
	public OffenceType addOffence(@RequestParam(name="offenceName", required=true) String offenceName,
			@RequestParam(name="offenceDuration", required=true) Double offenceDuration){
		return offenceHelper.addOffence(offenceName, offenceDuration);
	}
	
}
