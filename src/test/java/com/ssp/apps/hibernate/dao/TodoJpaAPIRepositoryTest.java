package com.ssp.apps.hibernate.dao;

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
public class TodoJpaAPIRepositoryTest {

	@Autowired
	private TodoJpaAPIRepository repository;

	@Test
	public void findById() {
		Todo todo = repository.findById(1);
		log.info("== >> {}", todo);
	}

}
