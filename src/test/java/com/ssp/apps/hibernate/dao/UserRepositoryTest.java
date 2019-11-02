package com.ssp.apps.hibernate.dao;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssp.apps.hibernate.HibernateApplication;
import com.ssp.apps.hibernate.entity.User;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
@Slf4j
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	@Test
	public void findById() {
		Optional<User> userOptional = repository.findById(1);
		if (userOptional.isPresent()) {
			log.info("== >> {}", userOptional.get());
		}
	}

}
