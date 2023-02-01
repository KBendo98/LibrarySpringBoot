package com.demo.library.exception;

public class BookNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String str) {
		super(str);
	}
}
