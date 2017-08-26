package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highcode.sms.model.SectionCategory;

@Repository
public interface ISectionCategoryRepository extends JpaRepository<SectionCategory, Integer> {

}
