package com.ssp.apps.hibernate.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssp.apps.hibernate.entity.Todo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class TodoHibernateAPIRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private Session session;

	@PostConstruct
	public void createHibernateSession() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		session = sessionFactory.openSession();
	}

	public Todo findById(Integer id) {
		return session.find(Todo.class, id);
	}

}
