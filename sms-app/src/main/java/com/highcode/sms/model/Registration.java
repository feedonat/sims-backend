package com.highcode.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private Student student;
	@OneToOne
	private AccedemicYear accYear;
	@OneToOne
	private Section section;
	private String status;
	
	
}