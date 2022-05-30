package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.AuthorDao;
import com.springrest.springrest.entities.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		return authorDao.findAll();
	}

	@Override
	public Author getAuthor(long id) {
		// TODO Auto-generated method stub
	 Author author=	 authorDao.getReferenceById(id);
	 return new Author(author.getId(), author.getName());
	}

	@Override
	public Author addAuthor(Author author) {
		// TODO Auto-generated method stub
		return authorDao.save(author);
	}

	@Override
	public Author updateAuthor(Author author) {
		// TODO Auto-generated method stub
		return authorDao.save(author);
	}

	@Override
	public void deleteAuthor(long id) {
		// TODO Auto-generated method stub
		authorDao.deleteById(id);

	}

}
