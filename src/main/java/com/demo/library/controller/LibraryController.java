package com.demo.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.library.dto.LibraryRequest;
import com.demo.library.exception.BookNotFoundException;
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
	public ResponseEntity<Library> getBookById(@PathVariable Integer id) throws BookNotFoundException{
		return new ResponseEntity<>(libraryService.getBookById(id), HttpStatus.FOUND);
	}

	@GetMapping("getBookByTitle/{title}")
	public ResponseEntity<Library> getBookByTitle(@PathVariable String title) throws BookNotFoundException{
		return new ResponseEntity<>(libraryService.getBookByTitle(title), HttpStatus.FOUND);
	}
	
	@GetMapping("getBookByAuthor/{author}")
	public ResponseEntity<Library> getBookByAuthor(@PathVariable String author) throws BookNotFoundException{
		return new ResponseEntity<>(libraryService.getBookByAuthor(author), HttpStatus.FOUND);
	}

	@PostMapping("/createBook")
	public ResponseEntity<Library> createBook(@RequestBody @Valid LibraryRequest request) {
		return new ResponseEntity<>(libraryService.createBook(request), HttpStatus.CREATED);
	}

	@PutMapping("/updateBook")
	public ResponseEntity<Library> updateBook(@RequestBody @Valid LibraryRequest request) throws BookNotFoundException {
		return new ResponseEntity<>(libraryService.updateBook(request), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable Integer id) throws BookNotFoundException{
		libraryService.deleteBook(id);
	}
}
