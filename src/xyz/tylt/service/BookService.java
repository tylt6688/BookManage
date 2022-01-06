package xyz.tylt.service;

import java.sql.SQLException;
import java.util.List;

import xyz.tylt.dao.BookDao;
import xyz.tylt.domain.Book;

public class BookService {
	BookDao bd = new BookDao();
	public List<Book> findAll() throws SQLException {
		return bd.findAll();
	}
	public int addBook(Book bk) throws SQLException {
		return bd.addBook(bk);
	}
	public int updateBook(Book bk) throws SQLException {
		return bd.updateBook(bk);
	}
	public int deleteBook(Book bk) throws SQLException {
		return bd.deleteBook(bk);
	}
}