package com.ssp.apps.hibernate.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssp.apps.hibernate.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
