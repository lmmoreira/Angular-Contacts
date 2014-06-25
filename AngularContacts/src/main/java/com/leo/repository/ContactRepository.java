package com.leo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findById(int id);
}