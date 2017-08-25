package com.highcode.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class StudentPhotoUploads {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	private AccademicYear year;
	@ManyToOne
	private Student student;
	@Lob
	private byte[] photo;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String status;
}
