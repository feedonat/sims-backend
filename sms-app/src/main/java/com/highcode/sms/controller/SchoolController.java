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
import com.highcode.sms.model.School;
import com.highcode.sms.service.ISchoolService;

@RestController

@RequestMapping("/api/v1/school")
public class SchoolController {

	private static final Logger logger = Logger.getLogger(SchoolController.class);

	@Autowired
	private ISchoolService schoolService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<School> addSchool(@RequestBody School school) throws GenericException {

		logger.info("addSchool() received the request for school" + school.toString());
		try {
			School saved = schoolService.save(school);
			logger.debug("saving school " + school);
			return new ResponseEntity<School>(saved, HttpStatus.CREATED);
		} catch (GenericException e) {
			logger.error("addSchool() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<School> getSchoolById(@PathVariable("id") int schoolId) throws GenericException {

		try {
			logger.info("getSchoolById() received the request for school id :" + schoolId);
			logger.debug("getSchoolById invoking for School ID" + schoolId);
			School response = schoolService.getSchoolById(schoolId);
			logger.debug("getSchoolById() response is :" + response);
			return new ResponseEntity<School>(response, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("getSchoolByid() exception occured for school id : " + schoolId + " - " + e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<School> updateSchool(@PathVariable("id") int id , @RequestBody School school) throws GenericException {

		System.err.print(school.toString());
		School currentSchool = schoolService.getSchoolById(id);
		currentSchool.setAddress(school.getAddress());
		currentSchool.setBranches(school.getBranches());
		currentSchool.setSchoolName(school.getSchoolName());
		currentSchool.setEmail(school.getEmail());
		currentSchool.setPhone(school.getPhone());
		
		logger.info("updateSchool() received the request for school" + school.toString());
		try {
			School updated = schoolService.save(currentSchool);
			logger.debug("updating school " + updated);
			return new ResponseEntity<School>(updated, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("addSchool() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
}
