package com.highcode.sms.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.highcode.sms.dao.ISchoolRepository;
import com.highcode.sms.exception.GenericException;
import com.highcode.sms.fileupload.StorageException;
import com.highcode.sms.fileupload.StorageService;
import com.highcode.sms.model.School;
import com.highcode.sms.service.ISchoolService;

@Service
public class ISchoolServiceImpl implements ISchoolService {

	
	
    @Autowired
    private StorageService storageService;
    
	@Autowired
	private ISchoolRepository schoolrepo;
	
	
	@Override
	public School save(School school) throws GenericException {
		
		System.out.println(school.getLogo());
		return schoolrepo.save(school);
	}

	@Override
	public School getSchoolById(int schoolId) {
		return schoolrepo.findOne(schoolId);
	}

	@Override
	public List<School> getAllSchools() {
		return schoolrepo.findAll();
	}
	@Override
	public void removeSchool(int schoolId) {
		School schoolToDelete = getSchoolById(schoolId);
        schoolrepo.delete(schoolToDelete);
		
	}

}
