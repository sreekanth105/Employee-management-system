package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.model.Book;
import com.cms.model.Library;
import com.cms.model.Student;
import com.cms.service.LibraryLoginService;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryController {

	@Autowired
	private LibraryLoginService repo;

	@PostMapping("/login")
	public ResponseEntity<?> libraryLogin(@RequestBody Library libraryData) {

		Library library = repo.getLibraryByLibrary(libraryData.getLusername());
		if (library.getLpassword().equals(libraryData.getLpassword()))
			return ResponseEntity.ok(library);

		return (ResponseEntity<?>) ResponseEntity.internalServerError();

	}

//	librarian can view all the list of books
	@GetMapping("/books")
	public List<Book> listBooks() {
		return repo.getAllBook();
	}
	
//	C add books
//	librarian can add books
	@PostMapping("/books")
	public Book addBooks(@RequestBody Book book) {
		return repo.addNewBook(book);
	}
	
//	D delete books 
//	librarian can delete book
	@DeleteMapping("/books/{book_id}")
	public void deleteBooks(@PathVariable("book_id") Integer id) {
		repo.deleteBook(id);
	}
	
}
