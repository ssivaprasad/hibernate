package com.ssp.apps.hibernate.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssp.apps.hibernate.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
