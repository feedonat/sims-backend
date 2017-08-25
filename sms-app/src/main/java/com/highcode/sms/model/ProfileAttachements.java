package com.highcode.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ProfileAttachements {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	@Lob
	public byte[] image;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	private Branch branch;
	
	
}
