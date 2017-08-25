package com.highcode.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private String email;
	private String phoneNo;
	@OneToMany(mappedBy="student",fetch=FetchType.LAZY)
	private List<StudentPhotoUploads> photos;
	@ManyToOne(cascade=CascadeType.REFRESH)
	private Guardian guardian;
	@ManyToOne
	private Branch branch;

}