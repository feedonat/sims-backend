package com.highcode.sms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.AccademicYear;
import com.highcode.sms.model.School;
import com.highcode.sms.model.Section;
import com.highcode.sms.service.ISchoolService;
import com.highcode.sms.service.ISectionService;

@RestController

@RequestMapping("/api/v1/section")
public class SectionController {

	private static final Logger logger = Logger.getLogger(SectionController.class);

	@Autowired
	private ISectionService sectionService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Section> addSection(@RequestBody Section section) throws GenericException {

		logger.info("addSection() received the request for school" + section.toString());
		try {
			Section saved = sectionService.save(section);
			logger.debug("saving Section " + saved);
			return new ResponseEntity<Section>(saved, HttpStatus.CREATED);
		} catch (GenericException e) {
			logger.error("addSection() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Section> getSectionById(@PathVariable("id") int id) throws GenericException {

		try {
			logger.info("getSection"
					+ "() received the request for section id :" + id);
			logger.debug("get Section invoking for Section ID" + id);
			Section response = sectionService.getSection(id);
			logger.debug("getSection by id () response is :" + response);
			return new ResponseEntity<Section>(response, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("getSection by id () exception occured for school id : " + id + " - " + e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Section> updateSection(@PathVariable("id") int id , @RequestBody Section section) throws GenericException {

		Section currentSection = sectionService.getSection(id);
		currentSection.setCategory(section.getCategory());
		currentSection.setCode(section.getCode());
		currentSection.setName(section.getName());
		currentSection.setStatus(section.getStatus());
		
		
		logger.info("updateSection() received the request for Section" + section.toString());
		try {
			Section updated = sectionService.save(currentSection);
			logger.debug("updating section " + updated);
			return new ResponseEntity<Section>(updated, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("updateSection() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
	
	/*removing a section from the database if the
	section is allready in use by a student 
	or other related tables we cant remove it.*/
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Section> deleteAccademicYear(@PathVariable("id") int id ) throws GenericException {

		
		Section currentSection = sectionService.getSection(id);	
		logger.info("remove Section method() received the request for year" + currentSection.toString());
		try {
			Section delete = sectionService.remove(currentSection);
			logger.debug("removing  Section " + delete);
			return new ResponseEntity<Section>(delete, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("remove Section () exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
	
	
}
