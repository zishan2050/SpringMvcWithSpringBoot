package com.demo.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.db.DetentionPeriod;
import com.demo.db.Student;
import com.demo.jpa.DetentionPeriodJPA;

public class CalculationModeHelper {
	
	@Autowired DetentionPeriodJPA detentionPeriodJPA;
	
	public DetentionPeriod consecutiveMode(Student student, Integer period, DetentionPeriod detentionPeriod){
		Calendar calendar = Calendar.getInstance();
		List<DetentionPeriod> lastDetentionPeriods = detentionPeriodJPA.findLastByStudent(student);
		DetentionPeriod lastDetentionPeriod = null;
		if(lastDetentionPeriods.size() > 0){
			lastDetentionPeriod = lastDetentionPeriods.get(lastDetentionPeriods.size()-1);
		}
		
		if(lastDetentionPeriod != null){
			if(calendar.getTimeInMillis() < lastDetentionPeriod.getEndDate().getTime())
				calendar.setTimeInMillis(lastDetentionPeriod.getEndDate().getTime());
			
		}
		calendar.add(Calendar.MINUTE, period);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTimeInMillis(new Date().getTime());
		calendar2.set(Calendar.DATE, calendar.get(Calendar.DATE));
		calendar2.set(Calendar.HOUR_OF_DAY, 17);
		calendar2.set(Calendar.MINUTE, 0);
		calendar2.set(Calendar.SECOND, 0);
		if(calendar.getTimeInMillis() > calendar2.getTimeInMillis()){
			calendar.add(Calendar.DATE, 1);
			calendar.set(Calendar.AM_PM, Calendar.AM);
			calendar.set(Calendar.HOUR_OF_DAY, 8);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			detentionPeriod.setStartDate(new Timestamp(calendar.getTimeInMillis()));
			calendar.add(Calendar.MINUTE, period);
		}
		else{
			if(lastDetentionPeriod == null){
				calendar.setTime(new java.util.Date());
				detentionPeriod.setStartDate(new Timestamp(calendar.getTimeInMillis()));
				calendar.add(Calendar.MINUTE, period);
			}
			else{
				detentionPeriod.setStartDate(lastDetentionPeriod.getEndDate());
			}
			
		}
		detentionPeriod.setEndDate(new Timestamp(calendar.getTimeInMillis()));
		
		return detentionPeriod;
	}
	
	public DetentionPeriod concurrentMode(Student student, Integer period, DetentionPeriod detentionPeriod){
		Calendar calendar = Calendar.getInstance();
		List<DetentionPeriod> lastDetentionPeriods = detentionPeriodJPA.findLastByStudent(student);
		DetentionPeriod lastDetentionPeriod = null;
		if(lastDetentionPeriods.size() > 0){
			lastDetentionPeriod = lastDetentionPeriods.get(lastDetentionPeriods.size()-1);
		}
		
		if(lastDetentionPeriod != null){
			if(calendar.getTimeInMillis() < lastDetentionPeriod.getEndDate().getTime())
				calendar.setTimeInMillis(lastDetentionPeriod.getEndDate().getTime());
			
		}
		calendar.add(Calendar.MINUTE, period);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTimeInMillis(new Date().getTime());
		calendar2.set(Calendar.DATE, calendar.get(Calendar.DATE));
		calendar2.set(Calendar.HOUR_OF_DAY, 17);
		calendar2.set(Calendar.MINUTE, 0);
		calendar2.set(Calendar.SECOND, 0);
		if(calendar.getTimeInMillis() > calendar2.getTimeInMillis()){
			calendar.add(Calendar.DATE, 1);
			calendar.set(Calendar.AM_PM, Calendar.AM);
			calendar.set(Calendar.HOUR_OF_DAY, 8);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			detentionPeriod.setStartDate(new Timestamp(calendar.getTimeInMillis()));
			calendar.add(Calendar.MINUTE, period);
		}
		else{
			if(lastDetentionPeriod == null){
				calendar.setTime(new java.util.Date());
				detentionPeriod.setStartDate(new Timestamp(calendar.getTimeInMillis()));
				calendar.add(Calendar.MINUTE, period);
			}
			else{
				detentionPeriod.setStartDate(lastDetentionPeriod.getEndDate());
			}
			
		}
		
		detentionPeriod.setEndDate(new Timestamp(calendar.getTimeInMillis()));
		
		return detentionPeriod;
	}
	
}
