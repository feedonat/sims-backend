package com.highcode.sms.service;

import java.util.List;

import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.SectionCategory;

public interface ISectionCategoryService {

	SectionCategory save(SectionCategory category) throws GenericException;
	SectionCategory remove(SectionCategory category) throws GenericException;
	SectionCategory getCategoryById(int id) throws GenericException;
	List<SectionCategory> getAll() throws GenericException;
}
