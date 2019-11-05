package com.ssp.apps.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ssp.apps.hibernate.constant.BookType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_ID_GENERATOR")
	@SequenceGenerator(name = "BOOK_ID_GENERATOR", sequenceName = "BOOK_SEQ", initialValue = 1, allocationSize = 1)
	private Integer id;

	private String title;
	private String author;
	private String publisher;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "book_dtl_id", unique = true)
	private BookDetail bookDetail;

	@Enumerated
	private BookType bookType;

}
