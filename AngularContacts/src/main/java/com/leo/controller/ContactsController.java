package com.leo.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.model.Contact;
import com.leo.service.Serviceable;
 
@Controller
public class ContactsController {
 
    @Autowired
    private Serviceable<Contact, Integer> contactService;
 
    @RequestMapping(value = "/protected/service/contacts", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Contact> listAll() {
    	return contactService.findAll();
    }
    
    @RequestMapping(value = "/protected/service/contacts/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Contact listId(@PathVariable("id")int id) {
    	return contactService.findById(id);
    }
    
    @RequestMapping(value = "/protected/service/contacts/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id")int id) {
    	contactService.delete(id);
    }
    
    @RequestMapping(value = "/protected/service/contacts", method = RequestMethod.PUT)
    public @ResponseBody void update(@RequestBody Contact contact) {
        contactService.save(contact);
    }
    
    @RequestMapping(value = "/protected/service/contacts", method = RequestMethod.POST)
    public @ResponseBody void insert(@RequestBody Contact contact) {
        contactService.save(contact);
    }
    
}