package pl.coderslab.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

@Component
@Transactional
public class JPABookDao implements BookDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Book save(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		return null;
	}

}
