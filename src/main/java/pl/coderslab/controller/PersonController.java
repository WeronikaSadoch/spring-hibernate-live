package pl.coderslab.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonGroupDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonGroup;

@Controller
public class PersonController {
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private PersonGroupDao personGroupDao;
	
	@GetMapping(path = "/person/add")
	public String showRegistrationForm(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "person/registration";
	}
	
	@PostMapping(path = "/person/add")
	public String registerPerson(Person person) {
		
		// walidacja danych
		
		// zapisanie do bazy danych
		personDao.save(person);
		
		return "person/success";
	}
	
	@ModelAttribute("groups")
	public List<PersonGroup> findAllPersonGroups() {
		
		List<PersonGroup> personGroups = personGroupDao.findAll();
		
		return personGroups;
	}
	
	@PostConstruct
	public void initPersonGroup() {
		
		PersonGroup pg1 = new PersonGroup();
		pg1.setName("grupa 1");
		
		personGroupDao.save(pg1);
		
		PersonGroup pg2 = new PersonGroup();
		pg2.setName("grupa 2");
		
		personGroupDao.save(pg2);
		
		PersonGroup pg3 = new PersonGroup();
		pg3.setName("grupa 3");
		
		personGroupDao.save(pg3);
		
		PersonGroup pg4 = new PersonGroup();
		pg4.setName("grupa 4");
		
		personGroupDao.save(pg4);
	}
}
