package com.demo.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true, nullable=false)
	private String studentName;
	@Column(nullable=false)
	private Boolean offenceDone = false;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Boolean getOffenceDone() {
		return offenceDone;
	}
	public void setOffenceDone(Boolean offenceDone) {
		this.offenceDone = offenceDone;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", offenceDone=" + offenceDone + "]";
	}
	
}
