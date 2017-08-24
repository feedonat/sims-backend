package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highcode.sms.model.Registration;

@Repository
public interface IRegisterRepository extends JpaRepository<Registration, Integer> {

}
