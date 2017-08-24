package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highcode.sms.model.AccedemicYear;

@Repository
public interface IAccademicRepository extends JpaRepository<AccedemicYear, Integer> {

}
