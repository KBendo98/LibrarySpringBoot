package com.demo.library.service;

import java.util.List;

import com.demo.library.dto.LibraryRequest;
import com.demo.library.exception.BookNotFoundException;
import com.demo.library.model.Library;

public interface LibraryService {
	List<Library> getAllBooks();
	Library getBookById(Integer id) throws BookNotFoundException;
	Library getBookByTitle(String title) throws BookNotFoundException;
	Library getBookByAuthor(String author) throws BookNotFoundException;
	Library createBook(LibraryRequest bookRequest);
	Library updateBook(LibraryRequest bookRequest) throws BookNotFoundException;
	void deleteBook(Integer id) throws BookNotFoundException;
}
