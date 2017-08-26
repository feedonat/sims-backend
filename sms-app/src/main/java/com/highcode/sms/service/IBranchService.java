package com.highcode.sms.service;

import java.util.List;

import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.Branch;

public interface IBranchService {

	Branch save(Branch branch) throws GenericException;
	Branch getBranchById(int id)throws GenericException;
	void remove(Branch branch)throws GenericException;
	List<Branch> getAll()throws GenericException;
}
