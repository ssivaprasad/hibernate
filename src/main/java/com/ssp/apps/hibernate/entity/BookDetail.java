package com.ssp.apps.hibernate.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book_dtl")
@Getter
@Setter
@ToString(exclude = {"book"})
public class BookDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_DTL_ID_GENERATOR")
	@SequenceGenerator(name = "BOOK_DTL_ID_GENERATOR", sequenceName = "book_dtl_seq", initialValue = 1, allocationSize = 1)
	private Integer id;

	private String isbn;
	private Integer noOfPages;
	private Integer editionNo;

	@Temporal(TemporalType.DATE)
	private Date publishedDate;

	@OneToOne(mappedBy = "bookDetail", cascade = CascadeType.PERSIST)
	private Book book;
	
	public BookDetail() {
		this.publishedDate = new Date();
	}
	
	public void setBook(Book book) {
		this.book = book;
		book.setBookDetail(this);
	}
	
	
}
