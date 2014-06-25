package com.leo.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.leo.model.Contact;
import com.leo.service.Serviceable;
 
@RunWith(MockitoJUnitRunner.class)
public class ContactsControllerTest {
 
	@Mock
	private Serviceable<Contact, Integer> contactService;
	
	@InjectMocks
    private ContactsController contactsController;
	
	@Test
    public void listAll() {
		Mockito.when(contactService.findAll()).thenReturn(getContacts());
		List<Contact> contacts = contactsController.listAll();
		Assert.assertFalse(contacts.isEmpty());
		Assert.assertEquals(getContact(), contacts.get(0));
    }
	
	public List<Contact> getContacts(){
		List<Contact> contacts = new ArrayList<Contact>();
		Contact contact = new Contact();
		contact.setId(1);
		contacts.add(contact);
		return contacts;
	}
	
	public Contact getContact(){
		Contact contact = new Contact();
		contact.setId(1);
		return contact;
	}
    
}