package com.ssp.apps.hibernate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ssp.apps.hibernate.dao.TodoRepository;
import com.ssp.apps.hibernate.entity.Todo;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired TodoRepository repository) {
		return (args) -> {
			// repository.save(new Todo("Learn Hibernate", new Date()));
			// repository.save(new Todo("Learn Spring", new Date()));
		};
	}
}
