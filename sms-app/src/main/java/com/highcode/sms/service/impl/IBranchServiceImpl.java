package com.highcode.sms.service.impl;

import java.util.List;

import com.highcode.sms.dao.IBranchRepository;
import com.highcode.sms.exception.GenericException;
import com.highcode.sms.model.Branch;
import com.highcode.sms.service.IBranchService;

public class IBranchServiceImpl implements IBranchService {

	private IBranchRepository branchRepo;

	@Override
	public Branch save(Branch branch) throws GenericException {
		return branchRepo.save(branch);
	}

	@Override
	public Branch getBranchById(int id) throws GenericException {
		return branchRepo.getOne(id);
	}

	@Override
	public void remove(Branch branch) throws GenericException {
     branchRepo.delete(branch); 
	}

	@Override
	public List<Branch> getAll() throws GenericException {
		return branchRepo.findAll();
	}
	
	
}
