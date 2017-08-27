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
import com.highcode.sms.model.Branch;
import com.highcode.sms.service.IBranchService;


@RestController

@RequestMapping("/api/v1/branch")
public class BranchController {

	private static final Logger logger = Logger.getLogger(BranchController.class);

	@Autowired
	private IBranchService branchService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Branch> addBranch(@RequestBody Branch b) throws GenericException {

		logger.info("addBranch() received the request for Branch" + b.toString());
		try {
			Branch saved = branchService.save(b);
			logger.debug("saving Branch " + saved);
			return new ResponseEntity<Branch>(saved, HttpStatus.CREATED);
		} catch (GenericException e) {
			logger.error("addBranch() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Branch> getBranch(@PathVariable("id") int id) throws GenericException {

		try {
			logger.info("getBranch"
					+ "() received the request for Branch id :" + id);
			logger.debug("get branch invoking for branch ID" + id);
			Branch response = branchService.getBranchById(id);
			logger.debug("getSection by id () response is :" + response);
			return new ResponseEntity<Branch>(response, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("getSection by id () exception occured for Branch id : " + id + " - " + e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Branch> updateBranch(@PathVariable("id") int id , @RequestBody Branch b) throws GenericException {

		Branch currentBranch =branchService.getBranchById(id);
		currentBranch.setBranchAddress(b.getBranchAddress());
		currentBranch.setBranchEmail(b.getBranchEmail());
		currentBranch.setBranchName(b.getBranchName());
		currentBranch.setBranchPhone(b.getBranchPhone());
		currentBranch.setSchool(b.getSchool());
	
		
		logger.info("updating branch () received the request for Section" + b.toString());
		try {
			Branch updated = branchService.save(currentBranch);
			logger.debug("updating branch " + updated);
			return new ResponseEntity<Branch>(updated, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("updateSection() exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Branch> deleteAccademicYear(@PathVariable("id") int id ) throws GenericException {

		Branch currentBranch = branchService.getBranchById(id);	
		logger.info("remove Branch method() received the request for Branch" + currentBranch.toString());
		try {
			 branchService.remove(currentBranch);
			logger.debug("removing  Branch " + currentBranch);
			return new ResponseEntity<Branch>(currentBranch, HttpStatus.OK);
		} catch (GenericException e) {
			logger.error("remove Branch () exception occured : " + " - " + e.getMessage());
			throw e;
		}
	}
	
	
	
}
