package com.demo.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.library.model.Library;
import com.demo.library.service.LibraryService;

@RestController
public class LibraryController {
	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/getAllBooks")
	public List<Library> getAllBooks() {
		return libraryService.getAllBooks();
	}

	@GetMapping("getBookById/{id}")
	public Library getBookById(@PathVariable Integer id) {
		return libraryService.getBookById(id);
	}

	@GetMapping("getBookByTitle/{title}")
	public Library getBookByTitle(@PathVariable String title) {
		return libraryService.getBookByTitle(title);
	}
	
	@GetMapping("getBookByAuthor/{author}")
	public Library getBookByAuthor(@PathVariable String author) {
		return libraryService.getBookByAuthor(author);
	}

	@PostMapping("/createBook")
	public Library createBook(@RequestBody Library book) {
		return libraryService.createBook(book);
	}

	@PutMapping("/updateBook")
	public Library updateBook(@RequestBody Library book) {
		return libraryService.updateBook(book);
	}

	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable Integer id) {
		libraryService.deleteBook(id);
	}
}
