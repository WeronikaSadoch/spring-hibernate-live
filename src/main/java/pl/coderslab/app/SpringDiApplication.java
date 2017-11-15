package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.coderslab.conf.AppConfiguration;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

public class SpringDiApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		
		context.register(AppConfiguration.class);
		context.refresh();
		
		PublisherDao publisherDao = context.getBean(PublisherDao.class);
		BookDao bookDao = context.getBean(BookDao.class);
		
		Publisher publisher = new Publisher();
		publisher.setName("Jakis wydawca");
		
		System.out.println("Publsher: " + publisher);
		publisherDao.save(publisher);
		
		System.out.println("Publisher: " + publisher);
		
		for(int i = 0; i < 10; i++) {
			Book book = new Book();
			book.setTitle("Ala ma kota");
			book.setAuthor("Autor");
			book.setDescription("Jakis opis");
			book.setRating((byte)1);
			book.setPublisher(publisher);
		
			System.out.println(book);
		
			Book result = bookDao.save(book);
		
			System.out.println(result);
		}
		context.close();
		
		/*EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("bookstorePersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Create entitymanager: " + em);
		
		em.close();
		emf.close();*/
	}

}
