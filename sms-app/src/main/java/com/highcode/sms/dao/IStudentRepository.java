package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.highcode.sms.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
