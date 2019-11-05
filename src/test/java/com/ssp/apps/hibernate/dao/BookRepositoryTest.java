package com.ssp.apps.hibernate.dao;

import java.util.Date;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssp.apps.hibernate.HibernateApplication;
import com.ssp.apps.hibernate.constant.BookType;
import com.ssp.apps.hibernate.entity.Book;
import com.ssp.apps.hibernate.entity.BookDetail;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@Slf4j
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookDetailRepository bookDetailRepository;

	@Test
	@Ignore
	public void findById() {
		Optional<Book> bookOptional = bookRepository.findById(1);
		if (bookOptional.isPresent()) {
			log.info("== >> {}", bookOptional.get());
		}
	}

	@Test
	@Ignore
	public void save_without_cascade() {
		Book book = new Book();
		book.setTitle("Spring 5 Recipes");
		book.setAuthor(" Gary Mak");
		book.setPublisher("Apress");
		book.setBookType(BookType.PDF);

		BookDetail bookDetail = new BookDetail();
		bookDetail.setEditionNo(5);
		bookDetail.setIsbn("871254");
		bookDetail.setNoOfPages(640);
		book.setBookDetail(bookDetail);

		bookDetailRepository.save(bookDetail);
		bookRepository.save(book);

		Book book1 = bookRepository.findById(book.getId()).get();
		log.info("=== >>> {}", book1);
	}

	@Test
	public void save_with_cascade() {
		Book book = new Book();
		book.setTitle("Spring 5 Recipes");
		book.setAuthor(" Gary Mak");
		book.setPublisher("Apress");
		book.setBookType(BookType.PDF);

		BookDetail bookDetail = new BookDetail();
		bookDetail.setEditionNo(5);
		bookDetail.setIsbn("871254");
		bookDetail.setNoOfPages(640);
		book.setBookDetail(bookDetail);

		bookRepository.save(book);

		Book book1 = bookRepository.findById(book.getId()).get();
		log.info("=== >>> {}", book1);
	}

}
