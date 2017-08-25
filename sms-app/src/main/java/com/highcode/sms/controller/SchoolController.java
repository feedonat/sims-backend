package com.highcode.sms.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private ISchoolService schoolService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<School> addSchool(@RequestBody School school)	throws GenericException {
			
		logger.info("");
		try {
			School saved = schoolService.save(school);
			logger.debug("saving school "+school);
			return new ResponseEntity<School>(saved, HttpStatus.OK);
		}catch (Exception e) {
			logger.error("addSchool() exception occured : "
					+" - " + e.getMessage());
			throw e;
		}
	}
	
}
