package com.ssp.apps.hibernate.dao;

import javax.persistence.EntityManager;
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

    public Todo findById(Integer id) {
        Session session = getSession();
        return session.find(Todo.class, id);
    }

    private Session getSession() {
        if (session == null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            return entityManager.unwrap(Session.class);
        }
        return session;
    }
}
