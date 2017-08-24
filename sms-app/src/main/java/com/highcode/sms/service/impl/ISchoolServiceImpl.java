package com.highcode.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highcode.sms.dao.ISchoolRepository;
import com.highcode.sms.model.School;
import com.highcode.sms.service.ISchoolService;

@Service
public class ISchoolServiceImpl implements ISchoolService {

	@Autowired
	private ISchoolRepository schoolrepo;
	
	@Override
	public void save(School school) {
		schoolrepo.save(school);
	}

	@Override
	public School getSchoolById(int schoolId) {
		return schoolrepo.findOne(schoolId);
	}

	@Override
	public List<School> getAllSchools() {
		return schoolrepo.findAll();
	}
	@Override
	public void updateSchool(School school) {
	
		School schooltoupdate = getSchoolById(school.getSchoolId());
		schooltoupdate.setAddress(school.getAddress());
		schooltoupdate.setEmail(school.getEmail());
		schooltoupdate.setLogo(school.getLogo());
		schooltoupdate.setPhone(school.getPhone());
		schooltoupdate.setSchoolName(school.getSchoolName());
		schoolrepo.save(schooltoupdate);
	}
	@Override
	public void removeSchool(int schoolId) {
		School schoolToDelete = getSchoolById(schoolId);
		schoolrepo.delete(schoolToDelete);
		
	}

}
