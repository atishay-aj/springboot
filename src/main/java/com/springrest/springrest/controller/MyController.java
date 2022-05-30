package com.springrest.springrest.controller;

import java.util.List;

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

import com.springrest.springrest.entities.Book;
import com.springrest.springrest.services.BookService;

@RestController
public class MyController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Library Management";
	}
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
		return this.bookService.getBooks();
		
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable String id) {
		return this.bookService.getBook(Long.parseLong(id));
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return this.bookService.addBook(book);
	}
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) {
		return this.bookService.updateBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable String id){
		try {
			this.bookService.deleteBook(Long.parseLong(id));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
