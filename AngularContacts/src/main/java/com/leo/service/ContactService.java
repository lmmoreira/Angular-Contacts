package com.leo.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.model.Contact;
import com.leo.repository.ContactRepository;

 
@Service
public class ContactService implements Serviceable<Contact, Integer> {
 
    @Autowired
    private ContactRepository contactRepository;
    
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
    	return contactRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Contact findById(Integer Id) {
    	return contactRepository.findById(Id);
    }
 
    @Transactional
    public void save(Contact contact) {
        contactRepository.save(contact);
    }
 
    @Secured("ROLE_ADMIN")
    @Transactional
    public void delete(Integer contactId) {
        contactRepository.delete(contactId);
    }
    
}