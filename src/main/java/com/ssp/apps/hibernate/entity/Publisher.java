package com.ssp.apps.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "publisher")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PUBLISHER_ID_GENERATOR")
	@SequenceGenerator(name = "PUBLISHER_ID_GENERATOR", sequenceName = "PUBLISHE_SEQ", initialValue = 1, allocationSize = 1)
	private Integer id;

	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "publisher_id")
	private List<Book> books = new ArrayList<Book>();

	public Publisher(String name) {
		this.name = name;
	}

	public void addBook(Book book) {
		books.add(book);
	}
}
