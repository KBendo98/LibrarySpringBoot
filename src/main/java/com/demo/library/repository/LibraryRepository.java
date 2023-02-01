package com.demo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.library.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{
	Library findByTitle(String title);
	Library findByAuthor(String author);
	Library findByBookId(Integer id);
}
