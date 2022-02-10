package com.mouritech.swagger3springbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private Long stdId;
	
	private String stdName;
	
	private int stdAge;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Long stdId, String stdName, int stdAge) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdAge = stdAge;
	}

	public Long getStdId() {
		return stdId;
	}

	public void setStdId(Long stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getStdAge() {
		return stdAge;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}
	
	

}
