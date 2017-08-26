package com.highcode.sms.service;

import java.util.List;

import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.Section;

public interface ISectionService {

	Section save(Section section) throws GenericException;
	Section getSection(int id) throws GenericException;
	Section remove(Section section) throws GenericException;
	List<Section> getAll();
	
}
