package com.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.db.Student;
import com.demo.jpa.StudentJPA;

public class StudentHelper {
	
	@Autowired StudentJPA studentJPA;
	
	public Student getStudentByName(String name){
		return studentJPA.findByStudentName(name);
	}
	
	public Student createStudent(Student student){
		return studentJPA.save(student);
	}
	
}
