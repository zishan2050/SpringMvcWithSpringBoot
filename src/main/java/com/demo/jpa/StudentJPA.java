package com.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.db.Student;

public interface StudentJPA extends JpaRepository<Student, Long>{
	
	public Student findByStudentName(String studentName);
	
}
