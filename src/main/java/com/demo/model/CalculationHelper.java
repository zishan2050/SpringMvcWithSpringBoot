package com.demo.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.db.DetentionPeriod;
import com.demo.db.OffenceType;
import com.demo.db.Student;
import com.demo.jpa.DetentionPeriodJPA;

public class CalculationHelper {
	
	@Autowired private DetentionPeriodJPA detentionPeriodJPA;
	@Autowired private StudentHelper studentHelper;
	@Autowired private CalculationModeHelper calculationModeHelper;
	
	public Integer getDetentionPeriodOfStudent(String studentName, List<OffenceType> offences, String timeType, String calculationType){
		Student student = studentHelper.getStudentByName(studentName);
		if(student == null){
			student = new Student();
			student.setStudentName(studentName);
			student.setOffenceDone(false);
			student = studentHelper.createStudent(student);
		}
		
		double totalOffencePeriod = 0.0;
		for(OffenceType offence : offences){
			totalOffencePeriod += offence.getOffenceDuration();
		}
		if(totalOffencePeriod > 8.0){
			return -1;
		}
		
		Integer offencePeriod = 0;
		for(OffenceType offence : offences){
			if(timeType.equals("bad")){
				offencePeriod += getMinutes(offence.getOffenceDuration()) + (getMinutes(offence.getOffenceDuration())/10);
			}
			else if(timeType.equals("good")){
				offencePeriod += getMinutes(offence.getOffenceDuration()) - (getMinutes(offence.getOffenceDuration())/10);
			}
			storeDetentionPeriod(student, offence, offencePeriod, calculationType);
		}
				
		return offencePeriod;
	}
	
	private void storeDetentionPeriod(Student student, OffenceType offenceType, Integer period, String calculationType){
		DetentionPeriod detentionPeriod = new DetentionPeriod();
		detentionPeriod.setOffenceType(offenceType);
		detentionPeriod.setPeriod(period);
		detentionPeriod.setStudent(student);
		if(calculationType.equals("consecutive")){
			detentionPeriod = calculationModeHelper.consecutiveMode(student, period, detentionPeriod);
		}
		else if(calculationType.equals("concurrent")){
			detentionPeriod = calculationModeHelper.concurrentMode(student, period, detentionPeriod);
		}
		detentionPeriodJPA.save(detentionPeriod);
	}
	
	private int getMinutes(Double hours){
		return (int) Math.round(hours * 60);
	}
	
}
