package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.model.Student;
import com.cms.model.Timetable;
import com.cms.repo.StudentRepo;
import com.cms.repo.TimetableRepo;

@Service
public class StudentLoginService {

	@Autowired
	StudentRepo studentRepo;
	
	@Autowired 
	TimetableRepo timetableRepo;

	public Student getStudentByStudent(String username) {
		return studentRepo.findBySusername(username);
	}
	
	public Timetable getTimetableByStudent(String stream) {
		return timetableRepo.findByStream(stream);
	}

}