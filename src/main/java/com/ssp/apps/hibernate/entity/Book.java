package com.ssp.apps.hibernate.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ssp.apps.hibernate.constant.BookType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_ID_GENERATOR")
	@SequenceGenerator(name = "BOOK_ID_GENERATOR", sequenceName = "BOOK_SEQ")
	private Integer id;

	private String title;
	private String author;

	@Temporal(TemporalType.DATE)
	private Date publishedDate;

	@Enumerated
	private BookType bookType;

	public Book() {
		this.publishedDate = new Date();
	}
}
