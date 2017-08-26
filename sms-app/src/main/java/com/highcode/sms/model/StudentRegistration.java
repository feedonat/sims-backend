package com.highcode.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StudentRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private Student student;
	@OneToOne
	private AccademicYear accYear;
	@OneToOne
	private Section section;
	private String status;
	
	
}
