package com.cms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Timetable;

public interface TimetableRepo extends JpaRepository<Timetable, Integer>{
	
	Timetable findByStream(String stream);

}
