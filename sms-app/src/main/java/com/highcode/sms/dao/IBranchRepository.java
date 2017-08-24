package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.highcode.sms.model.Branch;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Integer>{

}
