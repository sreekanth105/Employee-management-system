package com.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.model.Admin;
import com.cms.model.Book;
import com.cms.model.Faculty;
import com.cms.model.Library;
import com.cms.model.Student;
import com.cms.model.Timetable;
import com.cms.repo.AdminRepo;
import com.cms.repo.BookRepo;
import com.cms.repo.FacultyRepo;
import com.cms.repo.LibraryRepo;
import com.cms.repo.StudentRepo;
import com.cms.repo.TimetableRepo;

@Service
@Transactional
public class AdminLoginService {

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	StudentRepo srepo;

	@Autowired
	FacultyRepo frepo;

	@Autowired
	LibraryRepo lrepo;
	
	@Autowired 
	TimetableRepo trepo;
	
	@Autowired
	BookRepo bookRepo;
	

	public Admin getAdminByAdmin(String username) {
		return adminRepo.findByAusername(username);
	}

//	For Student Actions
//	method for view from admin to student
	public List<Student> getAllStudent() {
		return srepo.findAll();
	}

// method for adding student
	public Student addNewStudent(Student student) {
		return srepo.save(student);
	}

// method for deleting the student entry
	public void removeStudentDetails(String susername) {
		srepo.deleteBySusername(susername);
	}

//	method for updating the student details
	public Student getStudentById(String susername) {
		return srepo.findById(susername).get();
	}

	public Student updateStudent(Student student) {
		return srepo.save(student);

	}

//	For Faculty Actions
//	method for view from admin to faculty
	public List<Faculty> getAllFaculty() {
		return frepo.findAll();
	}

//	method for adding the faculty
	public Faculty addNewFaculty(Faculty faculty) {
		return frepo.save(faculty);
	}

//	method for deleting the faculty entry
	public void removeFacultyDetails(String fusername) {
		frepo.deleteByFusername(fusername);
	}

//	method for updating the faculty details
	public Faculty getFacultyById(String fusername) {
		return frepo.findById(fusername).get();
	}

// method for saving the updated data
	public Faculty updateFaculty(Faculty faculty) {
		return frepo.save(faculty);
	}

//	For Library Actions

//	method for view from admin to library
	public List<Library> getAllLibrary() {
		return lrepo.findAll();
	}

//	method for adding the faculty
	public Library addNewLibrary(Library library) {
		return lrepo.save(library);
	}

//	method for deleting the library entry
	public void removeLibraryDetails(String lusername) {
		lrepo.deleteByLusername(lusername);
	}

//	method for updating the student details
	public Library getLibraryById(String lusername) {
		return lrepo.findById(lusername).get();
	}

// method for saving the updated data
	public Library updateLibrary(Library library) {
		return lrepo.save(library);
	}
	
//	method for viewing the timetable
	public List<Timetable> getAllTimetable(){
		return trepo.findAll();
	}

//	method for adding timetable
	public Timetable addNewTimetable(Timetable timetable) {
		return trepo.save(timetable);
	}
	
//	mthod for deleting the timetable
	public void removeTimetableDetails(Integer timetableId) {
		trepo.deleteById(timetableId);
	}
	
//	method for view all the books available
	public List<Book> getAllBook(){
		return bookRepo.findAll();
	}
}