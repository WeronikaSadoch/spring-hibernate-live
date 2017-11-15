package pl.coderslab.dao;

import pl.coderslab.entity.Book;

public interface BookDao {

	Book save(Book book);
	Book update(Book book);
}
