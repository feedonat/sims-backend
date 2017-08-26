package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highcode.sms.model.Section;

@Repository
public interface ISectionRepository extends JpaRepository<Section, Integer> {

}
