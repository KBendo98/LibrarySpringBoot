package com.demo.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.library.dto.LibraryRequest;
import com.demo.library.exception.BookNotFoundException;
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
	public Library getBookById(Integer id) throws BookNotFoundException{
		Library book = repository.findByBookId(id);
		if(book != null)
			return book;
		else {
			throw new BookNotFoundException("Book not found with id: "+ id);
		}
	}

	@Override
	public Library getBookByTitle(String title) throws BookNotFoundException{
		Library book = repository.findByTitle(title);
		if(book != null)
			return book;
		else {
			throw new BookNotFoundException("Book not found with title: "+ title);
		}
	}
	
	@Override
	public Library getBookByAuthor(String author) throws BookNotFoundException{
		Library book = repository.findByTitle(author);
		if(book != null)
			return book;
		else {
			throw new BookNotFoundException("Book not found with author: "+ author);
		}
	}

	@Override
	public Library createBook(LibraryRequest bookRequest){
		Library book = Library.build(0,bookRequest.getAuthor(),
				bookRequest.getTitle(), bookRequest.getCost());
		
		return repository.save(book);
	}

	@Override
	public Library updateBook(LibraryRequest bookRequest) throws BookNotFoundException{
		Library book = Library.build(0,bookRequest.getAuthor(),
				bookRequest.getTitle(), bookRequest.getCost());
		Library updatedBook = repository.findByBookId(book.getBookId());
		
		if(updatedBook != null) {
			updatedBook.setAuthor(book.getAuthor());
			updatedBook.setTitle(book.getTitle());
			updatedBook.setCost(book.getCost());
			
			return updatedBook;
		}
		else {
			throw new BookNotFoundException("Book not found with id: " + book.getBookId());
		}
	}

	@Override
	public void deleteBook(Integer id) throws BookNotFoundException{
		Library book = repository.findByBookId(id);
		
		if(book != null)
			repository.deleteById(id);
		else {
			throw new BookNotFoundException("Book not found with id: "+ id);
		}
	}
}
