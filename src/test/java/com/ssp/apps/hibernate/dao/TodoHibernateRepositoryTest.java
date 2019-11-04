package com.ssp.apps.hibernate.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssp.apps.hibernate.HibernateApplication;
import com.ssp.apps.hibernate.entity.Todo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@Slf4j
public class TodoHibernateRepositoryTest {

	@Autowired
	private TodoHibernateRepository repository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Before
	public void createSession() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		repository.setSession(session);
	}

	@Test
	public void findById() {
		Todo todo = repository.findById(1);
		log.info("== >> Retrieved Todo Object using hibernate load()");
		log.info("== >> {}", todo);
	}

	@Test
	public void save() {
		repository.save(new Todo("Learn Spring Boot", new Date()));
	}

}
