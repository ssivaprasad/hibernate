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
public class BookDetailRepositoryTest {

	@Autowired
	private BookDetailRepository bookDetailRepository;

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

		bookDetail.setBook(book);
		book.setBookDetail(bookDetail);

		bookDetailRepository.save(bookDetail);

		BookDetail bookDetails = bookDetailRepository.findById(bookDetail.getId()).get();
		log.info("=== >>> {}", bookDetails);
	}

}
