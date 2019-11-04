package com.ssp.apps.hibernate.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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
public class TodoJpaRepositoryTest {

	@Autowired
	private TodoJpaRepository repository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	@Before
	public void createEntityManger() {
		entityManager = entityManagerFactory.createEntityManager();
		repository.setEntityManager(entityManager);
	}

	@Test
	public void findById() {
		Todo todo = repository.findById(1);
		log.info("== >> Retrieved Todo Object using hibernate find()");
		log.info("== >> {}", todo);
	}

	@Test
	public void save() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		repository.save(new Todo("Learn Spring Boot", new Date()));

		transaction.commit();
	}

	@Test
	public void update_using_automatic_dirty_checking() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Todo todo = repository.findById(1);
		todo.setTaskName("Hibernate");

		transaction.commit();
	}

	@Test
	public void merge() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Todo todo = repository.findById(1);
		todo.setTaskName("Lets learn Hibernate");

		entityManager.merge(todo);
		transaction.commit();
	}
}
