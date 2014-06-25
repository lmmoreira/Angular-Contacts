package com.leo.repository;

import org.springframework.data.repository.CrudRepository;

import com.leo.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}