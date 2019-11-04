package com.ssp.apps.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssp.apps.hibernate.entity.Todo;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Repository
@Setter
@Slf4j
public class TodoHibernateRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private Session session;

	public Todo findById(Integer id) {
		Session session = getSession();
		return session.load(Todo.class, id);
	}

	public Todo save(Todo todo) {
		Session session = getSession();
		EntityTransaction transaction = session.getTransaction();
		transaction.begin();

		session.save(todo);

		transaction.commit();
		return todo;
	}

	private Session getSession() {
		if (session == null) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return entityManager.unwrap(Session.class);
		}
		return session;
	}
}
