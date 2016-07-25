package com.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.db.DetentionPeriod;
import com.demo.db.Student;

public interface DetentionPeriodJPA extends JpaRepository<DetentionPeriod, Long>{
	
	public List<DetentionPeriod> findLastByStudent(Student student);
}
