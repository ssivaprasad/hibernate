package com.ssp.apps.hibernate.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssp.apps.hibernate.entity.Todo;

@Repository
public class TodoJpaAPIRepository {

	@Autowired
	private EntityManager entityManager;

	public Todo findById(Integer id) {
		return entityManager.find(Todo.class, id);
	}
}
