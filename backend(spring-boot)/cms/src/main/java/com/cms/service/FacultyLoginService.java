package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.model.Faculty;
import com.cms.model.Timetable;
import com.cms.repo.FacultyRepo;
import com.cms.repo.TimetableRepo;

@Service
public class FacultyLoginService {

	
	@Autowired
	FacultyRepo facultyRepo;
	
	@Autowired 
	TimetableRepo trepo;
	
	public Faculty getFacultyByFaculty(String username) {
		return facultyRepo.findByFusername(username);
	}
	
	
//	method for viewing the timetable
	public List<Timetable> getAllTimetable(){
		return trepo.findAll();
	}
}
