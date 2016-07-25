package com.demo.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OffenceType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true, nullable=false)
	private String offenceName;
	@Column(nullable=false)
	private Double offenceDuration;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOffenceName() {
		return offenceName;
	}
	public void setOffenceName(String offenceName) {
		this.offenceName = offenceName;
	}
	public Double getOffenceDuration() {
		return offenceDuration;
	}
	public void setOffenceDuration(Double offenceDuration) {
		this.offenceDuration = offenceDuration;
	}
	
	@Override
	public String toString() {
		return "OffenceType [id=" + id + ", offenceName=" + offenceName + ", offenceDuration=" + offenceDuration + "]";
	}
	
}
