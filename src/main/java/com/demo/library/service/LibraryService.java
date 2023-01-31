package com.demo.library.service;

import java.util.List;

import com.demo.library.model.Library;

public interface LibraryService {
	List<Library> getAllBooks();
	Library getBookById(Integer id);
	Library getBookByTitle(String title);
	Library getBookByAuthor(String author);
	Library createBook(Library book);
	Library updateBook(Library book);
	void deleteBook(Integer id);
}
