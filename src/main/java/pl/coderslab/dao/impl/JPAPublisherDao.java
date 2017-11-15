package pl.coderslab.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class JPAPublisherDao implements PublisherDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Publisher save(Publisher publisher) {
		em.persist(publisher);
		return publisher;
	}
}