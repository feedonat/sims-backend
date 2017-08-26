package com.highcode.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highcode.sms.model.StudentPhotoUploads;

@Repository
public interface IStudentPhotoUploadsRepository extends JpaRepository<StudentPhotoUploads, Integer> {

}
