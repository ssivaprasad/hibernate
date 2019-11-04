package com.ssp.apps.hibernate.dao;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssp.apps.hibernate.HibernateApplication;
import com.ssp.apps.hibernate.constant.BookType;
import com.ssp.apps.hibernate.entity.Book;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@Slf4j
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Test
	public void findById() {
		Optional<Book> bookOptional = repository.findById(1);
		if (bookOptional.isPresent()) {
			log.info("== >> {}", bookOptional.get());
		}
	}

	@Test
	public void save() {
		Book book = new Book();
		book.setTitle("Hibernate");
		book.setAuthor("Siva");
		book.setBookType(BookType.PDF);
		book.setPublishedDate(new Date());

		repository.save(book);

		Book book1 = repository.findById(book.getId()).get();
		log.info("=== >>> {}", book1);
	}

}
