package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.model.Book;
import com.cms.model.Library;
import com.cms.repo.BookRepo;
import com.cms.repo.LibraryRepo;


@Service
public class LibraryLoginService {

	@Autowired
	LibraryRepo libraryRepo;
	
	@Autowired
	BookRepo bookRepo;
	
	public Library getLibraryByLibrary(String username) {
		return libraryRepo.findByLusername(username);
	}
	
//	method for view all the books available
	public List<Book> getAllBook(){
		return bookRepo.findAll();
	}
	
	public Book addNewBook(Book book) {
		return bookRepo.save(book);
	}
	
	public void deleteBook(Integer id) {
		bookRepo.deleteById(id);
	}
	
}
