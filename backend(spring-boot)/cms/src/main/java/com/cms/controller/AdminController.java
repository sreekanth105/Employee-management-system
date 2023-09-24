package com.cms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.cms.model.Admin;
import com.cms.model.Book;
import com.cms.model.Faculty;
import com.cms.model.Library;
import com.cms.model.Student;
import com.cms.model.Timetable;
import com.cms.service.AdminLoginService;
import com.cms.service.StudentLoginService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")

public class AdminController {

	@Autowired
	private AdminLoginService repo;

//	admin can login in the admin-dashboard
	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@RequestBody Admin adminData) {

		Admin admin = repo.getAdminByAdmin(adminData.getAusername());
		if (admin.getApassword().equals(adminData.getApassword()))
			return ResponseEntity.ok(admin);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();

	}

//	Methods for Students
//	R view list of all the students
//	admin can view all the profile of students 
	@GetMapping("/students")
	public List<Student> listStudents() {
		return repo.getAllStudent();
	}

//	C add student
//	admin can add a profile of student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return repo.addNewStudent(student);
	}

//	D delete student
//	admin can delete the profile of student
	@DeleteMapping("/students/{susername}")
	public void removeStudent(@PathVariable("susername") String susername) {
		repo.removeStudentDetails(susername);
	}

	@GetMapping(value = "/students", params = { "susername" })
	public ResponseEntity<?> student(@RequestParam String susername) {
		return ResponseEntity.ok(repo.getStudentById(susername));
	}

//	U update student
//	admin can update student's profile
	@PutMapping("/students")
	public ResponseEntity<?> update(@RequestBody Student student) {
		Student old = repo.getStudentById(student.getSusername());

		if (old != null) {
			return ResponseEntity.ok(repo.addNewStudent(student));
		}
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}

//	Methods for Faculties

//	R get the list of all faculty
	@GetMapping("/faculty")
	public List<Faculty> listFaculty() {
		return repo.getAllFaculty();
	}

//	C add faculty
	@PostMapping("/faculty")
	public Faculty addFaculty(@RequestBody Faculty faculty) {
		return repo.addNewFaculty(faculty);
	}

//	D delete faculty
//	admin can delete the profile of faculty
	@DeleteMapping("/faculty/{fusername}")
	public void removeFaculty(@PathVariable("fusername") String fusername) {
		repo.removeFacultyDetails(fusername);
	}

	@GetMapping(value = "/faculty", params = { "fusername" })
	public ResponseEntity<?> faculty(@RequestParam String fusername) {
		return ResponseEntity.ok(repo.getFacultyById(fusername));
	}

//	U update faculty
//	admin can update profile of Faculty
	@PutMapping("/update-faculty")
	public ResponseEntity<?> update(@RequestBody Faculty faculty) {
		Faculty old = repo.getFacultyById(faculty.getFusername());
		if (old != null) {
			return ResponseEntity.ok(repo.updateFaculty(faculty));
		}
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}

//	Methods for Librarian
//	R get the list of all librarian
	@GetMapping("/library")
	public List<Library> listLibrary() {
		return repo.getAllLibrary();
	}

//	C add librarian
	@PostMapping("/library")
	public Library addLibrary(@RequestBody Library library) {
		return repo.addNewLibrary(library);
	}

//	D delete faculty
//	admin can delete the profile of library
	@DeleteMapping("/library/{lusername}")
	public void removeLibrary(@PathVariable("lusername") String lusername) {
		repo.removeLibraryDetails(lusername);
	}

	@GetMapping(value = "/library", params = { "lusername" })
	public ResponseEntity<?> library(@RequestParam String lusername) {
		return ResponseEntity.ok(repo.getLibraryById(lusername));
	}

//	U update librarian
//	admin can update profile of librarian
	@PutMapping("/library")
	public ResponseEntity<?> update(@RequestBody Library library) {
		Library old = repo.getLibraryById(library.getLusername());
		if (old != null) {
			return ResponseEntity.ok(repo.updateLibrary(library));
		}
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
	
//	R admin can view timetable
	@GetMapping("/timetable")
	public List<Timetable> listTimetable() {
		return repo.getAllTimetable();
	}
	
//	C admin can add timetable
	@PostMapping("/timetable")
	public Timetable addTimetable(@RequestBody Timetable timetable) {
		return repo.addNewTimetable(timetable);
	}
	
//	D admin can delete timetable
	@DeleteMapping("/timetable/{timetableId}")
	public void removeTimetable(@PathVariable("timetableId") Integer timetableId) {
		repo.removeTimetableDetails(timetableId);
	}
	
//	R admin can view all the list of books
	@GetMapping("/get/books")
	public List<Book> listBooks() {
		return repo.getAllBook();
	}

}