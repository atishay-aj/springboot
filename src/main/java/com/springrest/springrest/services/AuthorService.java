package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Author;

public interface AuthorService {

	List<Author> getAuthors();

	Author getAuthor(long parseLong);

	Author addAuthor(Author author);

	Author updateAuthor(Author author);

	void deleteAuthor(long parseLong);

}
