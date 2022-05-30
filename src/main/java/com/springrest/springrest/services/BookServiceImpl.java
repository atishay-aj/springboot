package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.BookDao;
import com.springrest.springrest.entities.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

//	List<Book> list;

	public BookServiceImpl() {
//		list =new ArrayList<Book>();
//		list.add(new Book(1, "Java", "AJ"));
//		list.add(new Book(2, "C++", "RJ"));
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	@Override
	public Book getBook(long id) {
		// TODO Auto-generated method stub

//		Book b=null;
//		for(Book book:list) {
//			if(book.getId()==id) {
//				b=book;
//				break;
//			}
//		}

		Book book = bookDao.getReferenceById(id);
		System.out.println(book.getAuthor());
		return new Book(book.getId(), book.getName(), book.getAuthor());
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
//		list.add(book);
		bookDao.save(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
//		list.forEach(e->{
//			if(e.getId()==book.getId()) {
//				e.setName(book.getName());
//				e.setAuthor(book.getAuthor());
//			}
//		});
		bookDao.save(book);
		return book;
	}

	@Override
	public void deleteBook(long id) {
		// TODO Auto-generated method stub
//		list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		bookDao.deleteById(id);
	}

}
