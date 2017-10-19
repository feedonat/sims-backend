package com.highcode.sms.service;

import java.util.List;

import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.School;

public interface ISchoolService {

	School save(School school) throws GenericException;
	School getSchoolById(int schoolId)throws GenericException;
	List<School> getAllSchools()throws GenericException;
	void removeSchool(int schoolId)throws GenericException;
}
