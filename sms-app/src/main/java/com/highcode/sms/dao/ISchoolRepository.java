package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highcode.sms.model.School;

@Repository
public interface ISchoolRepository extends JpaRepository<School, Integer> {

}
