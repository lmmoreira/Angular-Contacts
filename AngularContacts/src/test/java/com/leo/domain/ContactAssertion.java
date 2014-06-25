package com.leo.domain;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import com.leo.model.Contact;

public class ContactAssertion extends AbstractAssert<ContactAssertion, Contact> {

	protected ContactAssertion(Contact actual) {
		super(actual, ContactAssertion.class);
	}
	
	public static ContactAssertion assertThat(Contact actual) {
		return new ContactAssertion(actual);
	}
	
	public ContactAssertion hasEmail(String email) {
		isNotNull();
			 
		Assertions.assertThat(actual.getEmail()).overridingErrorMessage( "Expected email to be <%s> but was <%s>", email, actual.getEmail()).isEqualTo(email);
		return this;
	}
	
	public ContactAssertion hasName(String name) {
		isNotNull();
			 
		Assertions.assertThat(actual.getName()).overridingErrorMessage( "Expected name to be <%s> but was <%s>", name, actual.getName()).isEqualTo(name);
		return this;
	}
			 

	
}
