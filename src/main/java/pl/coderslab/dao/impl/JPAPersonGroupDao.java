package pl.coderslab.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.coderslab.dao.PersonGroupDao;
import pl.coderslab.entity.PersonGroup;

@Component
@Transactional
public class JPAPersonGroupDao implements PersonGroupDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public PersonGroup save(PersonGroup personGroup) {
		em.persist(personGroup);
		return personGroup;
	}

	@Override
	public List<PersonGroup> findAll() {
		Query query = em.createQuery("SELECT pg from PersonGroup AS pg");
		List<PersonGroup> result = query.getResultList();
		return result;
	}

	@Override
	public PersonGroup findById(long id) {
		PersonGroup personGroup = em.find(PersonGroup.class, id);
		return personGroup;
	}
}
