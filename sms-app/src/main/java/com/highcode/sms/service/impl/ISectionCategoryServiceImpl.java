package com.highcode.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highcode.sms.dao.ISectionCategoryRepository;
import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.SectionCategory;
import com.highcode.sms.service.ISectionCategoryService;

@Service
public class ISectionCategoryServiceImpl implements ISectionCategoryService {

	@Autowired
	private ISectionCategoryRepository sectionCategoryRepo;
	
	@Override
	public SectionCategory save(SectionCategory category) throws GenericException {
		// TODO Auto-generated method stub
		return sectionCategoryRepo.save(category);
	}

	@Override
	public SectionCategory remove(SectionCategory category) throws GenericException {
		
		SectionCategory cat = category;
		sectionCategoryRepo.delete(category);
		return cat;
	}

	@Override
	public SectionCategory getCategoryById(int id) throws GenericException {
		// TODO Auto-generated method stub
		return sectionCategoryRepo.findOne(id);
	}

	@Override
	public List<SectionCategory> getAll() throws GenericException {
		// TODO Auto-generated method stub
		return sectionCategoryRepo.findAll();
	}

}
