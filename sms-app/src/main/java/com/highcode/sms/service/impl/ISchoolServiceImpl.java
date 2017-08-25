package com.highcode.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highcode.sms.dao.ISchoolRepository;
import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.School;
import com.highcode.sms.service.ISchoolService;

@Service
public class ISchoolServiceImpl implements ISchoolService {

	@Autowired
	private ISchoolRepository schoolrepo;
	
	@Override
	public School save(School school) throws GenericException {
		return schoolrepo.save(school);
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
	public void removeSchool(int schoolId) {
		School schoolToDelete = getSchoolById(schoolId);
        schoolrepo.delete(schoolToDelete);
		
	}

}
