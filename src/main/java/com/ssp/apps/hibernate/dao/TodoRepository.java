package com.ssp.apps.hibernate.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssp.apps.hibernate.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
