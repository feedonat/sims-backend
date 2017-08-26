package com.highcode.sms.service;

import java.util.List;

import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.AccademicYear;

public interface IAccademicYearService {

	AccademicYear save(AccademicYear year) throws GenericException;
	AccademicYear remove(AccademicYear year)throws GenericException;
	AccademicYear getYearById(int id)throws GenericException;
	List<AccademicYear> getAll()throws GenericException;
}
