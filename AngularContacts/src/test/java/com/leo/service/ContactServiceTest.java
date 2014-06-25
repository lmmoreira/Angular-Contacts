package com.leo.service;
 
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.leo.model.Contact;
import com.leo.domain.ContactAssertion;
 
@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
 
	@Mock
	private Serviceable<Contact, Integer> contactService;
	
	@Test
    public void listAll() {
		Mockito.when(contactService.findAll()).thenReturn(getContacts());
		List<Contact> contacts = contactService.findAll();
		Assert.assertFalse(contacts.isEmpty());
		Assert.assertEquals(getContact(), contacts.get(0));
		
		//
		ContactAssertion.assertThat(contacts.get(0)).hasEmail("leo").hasName("leo");
		
    }
	
	public List<Contact> getContacts(){
		List<Contact> contacts = new ArrayList<Contact>();
		Contact contact = new Contact();
		contact.setId(1);
		contact.setEmail("leo");
		contact.setName("leo");
		contacts.add(contact);
		return contacts;
	}
	
	public Contact getContact(){
		Contact contact = new Contact();
		contact.setId(1);
		return contact;
	}
    
}