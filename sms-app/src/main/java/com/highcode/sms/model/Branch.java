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
	
	 @OneToMany(mappedBy="branch",fetch=FetchType.LAZY)
	 private List<ProfileAttachements> attachements;
	 
	 @ManyToOne(cascade= CascadeType.ALL)
	private School school;


}
