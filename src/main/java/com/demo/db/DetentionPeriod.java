package com.demo.db;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetentionPeriod {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="studentId")
	private Student student;
	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="offenceTypeId")
	private OffenceType offenceType;
	@Column(nullable=false)
	private Integer period;
	@Column(nullable=false)
	private Timestamp startDate;
	@Column(nullable=false)
	private Timestamp endDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public OffenceType getOffenceType() {
		return offenceType;
	}

	public void setOffenceType(OffenceType offenceType) {
		this.offenceType = offenceType;
	}

	@Override
	public String toString() {
		return "DetentionPeriod [id=" + id + ", student=" + student + ", period=" + period + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
}
