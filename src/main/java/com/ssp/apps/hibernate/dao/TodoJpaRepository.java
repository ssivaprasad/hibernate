package com.ssp.apps.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssp.apps.hibernate.entity.Todo;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Repository
@Setter
@Slf4j
public class TodoJpaRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	public Todo findById(Integer id) {
		return getEntityManager().find(Todo.class, id);
	}

	public Todo save(Todo todo) {
		getEntityManager().persist(todo);
		return todo;
	}

	private EntityManager getEntityManager() {
		if (entityManager == null) {
			return entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

}
