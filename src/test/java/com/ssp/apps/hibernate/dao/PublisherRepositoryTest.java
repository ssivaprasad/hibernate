package com.ssp.apps.hibernate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssp.apps.hibernate.HibernateApplication;
import com.ssp.apps.hibernate.constant.BookType;
import com.ssp.apps.hibernate.entity.Book;
import com.ssp.apps.hibernate.entity.BookDetail;
import com.ssp.apps.hibernate.entity.Publisher;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@Slf4j
public class PublisherRepositoryTest {

	@Autowired
	private PublicherRepository publicherRepository;

	@Test
	public void save() {
		Publisher publisher = new Publisher("Apress");

		Book book = new Book();
		book.setTitle("Spring 5 Recipes");
		book.setAuthor(" Gary Mak");
		book.setBookType(BookType.PDF);

		BookDetail bookDetail = new BookDetail();
		bookDetail.setEditionNo(5);
		bookDetail.setIsbn("871254");
		bookDetail.setNoOfPages(640);

		book.setBookDetail(bookDetail);

		publisher.addBook(book);

		publicherRepository.save(publisher);
	}

}
