package com.ssp.apps.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "chapter")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHAPTER_ID_GENERATOR")
	@SequenceGenerator(name = "CHAPTER_ID_GENERATOR", sequenceName = "CHAPTER_SEQ", initialValue = 1, allocationSize = 1)
	private Integer id;

	private String name;
	private Integer chapterNo;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Book book;

	public Chapter(String name, Integer chapterNo) {
		this.name = name;
		this.chapterNo = chapterNo;
	}

}
