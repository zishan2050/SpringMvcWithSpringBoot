package com.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.db.OffenceType;
import com.demo.jpa.OffenceTypeJPA;

public class OffenceHelper {
	
	@Autowired private OffenceTypeJPA offenceTypeJPA; 
	
	public List<OffenceType> getAllOffence(){
		return offenceTypeJPA.findAll();
	}
	
	public OffenceType addOffence(String offenceName, Double offenceDuration){
		OffenceType offenceType = new OffenceType();
		offenceType.setOffenceName(offenceName);
		offenceType.setOffenceDuration(offenceDuration);
		return offenceTypeJPA.save(offenceType);
	}
}
