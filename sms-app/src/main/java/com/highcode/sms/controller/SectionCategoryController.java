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
import com.highcode.sms.model.SectionCategory;
import com.highcode.sms.service.ISectionCategoryService;


@RestController

@RequestMapping("/api/v1/sectioncategory")
public class SectionCategoryController {

	private static final Logger logger = Logger.getLogger(SectionCategoryController.class);

	@Autowired
	private ISectionCategoryService sectionCategoryService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<SectionCategory> addSectionCategory(@RequestBody SectionCategory cat ) throws GenericException {

		logger.info("addSectionCategory() received the request for school" + cat.toString());
		try {
			SectionCategory saved = sectionCategoryService.save(cat);
			logger.debug("saving Section Category " + saved);
			return new ResponseEntity<SectionCategory>(saved, HttpStatus.CREATED);
		} catch (GenericException e) {
			logger.error("addSectionCategory() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<SectionCategory> getSectionById(@PathVariable("id") int id) throws GenericException {

		try {
			logger.info("getSectionCategory"
					+ "() received the request for section category id :" + id);
			logger.debug("get Section category invoking for Section category ID" + id);
			SectionCategory response = sectionCategoryService.getCategoryById(id);
			logger.debug("getSectionCategory by id () response is :" + response);
			return new ResponseEntity<SectionCategory>(response, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("getSection by id () exception occured for school id : " + id + " - " + e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<SectionCategory> updateSectionCategory(@PathVariable("id") int id , @RequestBody SectionCategory cat) throws GenericException {

		SectionCategory currentSectionCat = sectionCategoryService.getCategoryById(id);
		currentSectionCat.setCode(cat.getCode());
		currentSectionCat.setName(cat.getName());
		logger.info("updateSectionCategory() received the request for SectionCategory" + currentSectionCat.toString());
		try {
			SectionCategory updated = sectionCategoryService.save(currentSectionCat);
			logger.debug("updating section Category " + updated);
			return new ResponseEntity<SectionCategory>(updated, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("updateSection() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
	
	/*removing a section from the database if the
	section is allready in use by a student 
	or other related tables we cant remove it.*/
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<SectionCategory> deleteAccademicYear(@PathVariable("id") int id ) throws GenericException {

		
		SectionCategory currentSectionCat = sectionCategoryService.getCategoryById(id);	
		logger.info("remove Section Category method() received the request for year" + currentSectionCat.toString());
		try {
			SectionCategory delete = sectionCategoryService.remove(currentSectionCat);
			logger.debug("removing  Section " + delete);
			return new ResponseEntity<SectionCategory>(delete, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("remove Section () exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
	
	
}
