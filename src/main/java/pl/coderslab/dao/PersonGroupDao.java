package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.PersonGroup;

public interface PersonGroupDao {

	PersonGroup save(PersonGroup personGroup);
	List<PersonGroup> findAll();
	PersonGroup findById(long id);
}
