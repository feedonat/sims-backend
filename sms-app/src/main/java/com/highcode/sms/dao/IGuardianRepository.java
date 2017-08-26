package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highcode.sms.model.Guardian;

@Repository
public interface IGuardianRepository extends JpaRepository<Guardian, Integer> {

}
