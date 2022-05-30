package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Book;

public interface BookService {

	public List<Book> getBooks();

	public Book getBook(long id);

	public Book addBook(Book book);

	public Book updateBook(Book book);

	public void deleteBook(long id);
}
