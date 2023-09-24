package com.cms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
