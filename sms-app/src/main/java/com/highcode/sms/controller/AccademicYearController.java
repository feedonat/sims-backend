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
import com.highcode.sms.service.IAccademicYearService;

@RestController
@RequestMapping("/api/v1/accademicyear")
public class AccademicYearController {

	private static final Logger logger = Logger.getLogger(SchoolController.class);

	@Autowired
	private IAccademicYearService accademicYearService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<AccademicYear> addSchool(@RequestBody AccademicYear year) throws GenericException {

		logger.info("add accademic year method () received the request for year" + year.toString());
		try {
			AccademicYear saved = accademicYearService.save(year);
			logger.debug("saving accademic year " + saved);
			return new ResponseEntity<AccademicYear>(saved, HttpStatus.CREATED);
		} catch (GenericException e) {
			logger.error("addSchool() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AccademicYear> getSchoolById(@PathVariable("id") int id) throws GenericException {

		try {
			logger.info("get accademic year by Id received the request for accademic year id :" + id);
			logger.debug("get accademic year method invoking for year ID" + id);
			AccademicYear response = accademicYearService.getYearById(id);
			logger.debug("getAccademicYear method () response is :" + response);
			return new ResponseEntity<AccademicYear>(response, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("getSchoolByid() exception occured for school id : " + id + " - " + e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<AccademicYear> updateSchool(@PathVariable("id") int id , @RequestBody AccademicYear year) throws GenericException {

		
		AccademicYear currentyear = accademicYearService.getYearById(id);
		currentyear.setName(currentyear.getName());
		currentyear.setStatus(currentyear.getStatus());
		
		logger.info("update accademic-year method() received the request for year" + year.toString());
		try {
			AccademicYear updated = accademicYearService.save(currentyear);
			logger.debug("updating  accademic year " + updated);
			return new ResponseEntity<AccademicYear>(updated, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("addSchool() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<AccademicYear> deleteAccademicYear(@PathVariable("id") int id ) throws GenericException {

		
		AccademicYear currentyear = accademicYearService.getYearById(id);	
		logger.info("remove accademic-year method() received the request for year" + currentyear.toString());
		try {
			AccademicYear delete = accademicYearService.remove(currentyear);
			logger.debug("removing  accademic year " + delete);
			return new ResponseEntity<AccademicYear>(delete, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("removeaccademicYear() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
	
}
