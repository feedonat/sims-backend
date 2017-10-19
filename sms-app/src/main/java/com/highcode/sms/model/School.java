package com.highcode.sms.model;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;


@Entity
public class School {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	private String schoolName;
	private String email;
	private String address;
	private String phone;
	private String mobile;
	
	@Lob
	private byte[] logo ;
     
    @OneToMany(mappedBy = "school",  fetch = FetchType.EAGER)
	private List<Branch> branch;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", schoolName=" + schoolName + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + ", mobile=" + mobile +  ", branch=" + branch
				+ "]";
	}
    
}
