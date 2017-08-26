package com.highcode.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highcode.sms.dao.ISectionRepository;
import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.Section;
import com.highcode.sms.service.ISectionService;

@Service
public class ISectionServiceImpl implements ISectionService{

	@Autowired
	private ISectionRepository sectionRepo;
	@Override
	public Section save(Section section) throws GenericException {
		// TODO Auto-generated method stub
		return sectionRepo.save(section);
	}

	@Override
	public Section getSection(int id) throws GenericException {
		// TODO Auto-generated method stub
		return sectionRepo.findOne(id);
	}

	@Override
	public Section remove(Section section) throws GenericException {
		Section sec = section;
		sectionRepo.delete(section);
		return sec;
	}

	@Override
	public List<Section> getAll() {
		// TODO Auto-generated method stub
		return sectionRepo.findAll();
	}

}
