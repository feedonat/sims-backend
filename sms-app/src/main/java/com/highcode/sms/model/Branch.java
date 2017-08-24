package com.highcode.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String branchName;
	private String branchAddress;
	private String branchPhone;
	private String branchEmail;
	@OneToMany(mappedBy = "branch")
	private List<Student> students;
	
	 @ManyToOne(cascade= CascadeType.ALL)
	private School school;

	public Branch(int id, String branchName, String branchAddress, String branchPhone, String branchEmail,
			List<Student> students, School school) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.branchPhone = branchPhone;
		this.branchEmail = branchEmail;
		this.students = students;
		this.school = school;
	}
    
	
    
	
}
