package com.highcode.sms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Guardian {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String fristName;
	private String middleName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	
	@OneToMany(mappedBy = "guardian",fetch = FetchType.EAGER)
	private List<Student> students = null;

	public Guardian(int id, String fristName, String middleName, String lastName, String address, String phone,
			String email, List<Student> students) {
		super();
		this.id = id;
		this.fristName = fristName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
