package com.highcode.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highcode.sms.dao.IAccademicRepository;
import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.AccademicYear;
import com.highcode.sms.service.IAccademicYearService;

@Service
public class IAccademicYearServiceImpl implements IAccademicYearService {

	@Autowired
	private IAccademicRepository accademicyearRepo;

	@Override
	public AccademicYear save(AccademicYear year) throws GenericException {
		// TODO Auto-generated method stub
		return accademicyearRepo.save(year);
	}

	@Override
	public AccademicYear remove(AccademicYear year) throws GenericException {
		AccademicYear deleted = year;
		accademicyearRepo.delete(year);
		return deleted;
	}

	@Override
	public AccademicYear getYearById(int id) throws GenericException {
		
		return accademicyearRepo.getOne(id);
	}

	@Override
	public List<AccademicYear> getAll() throws GenericException {
		// TODO Auto-generated method stub
		return accademicyearRepo.findAll();
	}
}
