package com.highcode.sms.service;

import java.util.List;

import com.highcode.sms.model.School;

public interface ISchoolService {

	School save(School school);
	School getSchoolById(int schoolId);
	List<School> getAllSchools();
	School updateSchool(School schoolId);
	void removeSchool(int schoolId);
}
