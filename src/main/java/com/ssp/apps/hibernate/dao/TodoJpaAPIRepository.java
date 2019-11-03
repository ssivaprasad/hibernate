package com.ssp.apps.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssp.apps.hibernate.entity.Todo;

import lombok.Setter;

@Repository
@Setter
public class TodoJpaAPIRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	public Todo findById(Integer id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Todo.class, id);
	}

	public Todo save(Todo todo) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.persist(todo);

		transaction.commit();
		return todo;
	}

	private EntityManager getEntityManager() {
		if (entityManager == null) {
			return entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

}
