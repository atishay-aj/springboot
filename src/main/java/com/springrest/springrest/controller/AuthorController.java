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

import com.springrest.springrest.entities.Author;
import com.springrest.springrest.services.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/authors")
	public List<Author> getAuthors() {

		return this.authorService.getAuthors();

	}

	@GetMapping("/authors/{id}")
	public Author getAuthor(@PathVariable String id) {
		return this.authorService.getAuthor(Long.parseLong(id));
	}

	@PostMapping("/authors")
	public Author addAuthor(@RequestBody Author author) {
		return this.authorService.addAuthor(author);
	}

	@PutMapping("/authors")
	public Author updateAuthor(@RequestBody Author author) {
		return this.authorService.updateAuthor(author);
	}

	@DeleteMapping("/authors/{id}")
	public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable String id) {
		try {
			this.authorService.deleteAuthor(Long.parseLong(id));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
