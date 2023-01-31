package com.demo.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.library.model.Library;
import com.demo.library.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService{
	@Autowired
	LibraryRepository repository;
	
	@Override
	public List<Library> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public Library getBookById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Library getBookByTitle(String title) {
		return repository.findByTitle(title);
	}
	
	@Override
	public Library getBookByAuthor(String author) {
		return repository.findByAuthor(author);
	}

	@Override
	public Library createBook(Library book) {
		return repository.save(book);
	}

	@Override
	public Library updateBook(Library book) {
		Library b = repository.findById(book.getId()).orElse(null);
		try {
			b.setAuthor(book.getAuthor());
			b.setTitle(book.getTitle());
			b.setCost(book.getCost());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return b;
	}

	@Override
	public void deleteBook(Integer id) {
		repository.deleteById(id);
	}
}
