package com.leo.interceptor;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.leo.model.Contact;
import com.leo.model.User;
import com.leo.service.UserService;
 
@RunWith(PowerMockRunner.class)
@PrepareForTest( { SecurityContextHolder.class })
public class LoginInterceptorTest {
 
	@Mock
	private UserService userService;
	
	@InjectMocks
    private LoginInterceptor loginInterceptor;
	
	@Test
    public void preHandle() throws Exception {
		Mockito.when(userService.findByEmail(Mockito.anyString())).thenReturn(getUser());
	    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
	    HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);
	    HttpSession sess = Mockito.mock(HttpSession.class);
	    
        PowerMockito.mockStatic(SecurityContextHolder.class);
	    
	    SecurityContext ct = Mockito.mock(SecurityContext.class);
	    Authentication auth = Mockito.mock(Authentication.class);
	    Object obj = Mockito.mock(Object.class);
	    
	    Mockito.when(req.getSession()).thenReturn(sess);
	    Mockito.when(sess.getAttribute(Mockito.anyString())).thenReturn(null);
	    Mockito.when(SecurityContextHolder.getContext()).thenReturn(ct);
	    Mockito.when(ct.getAuthentication()).thenReturn(auth);
	    
		Assert.assertTrue(loginInterceptor.preHandle(req, resp, obj));
		
    }
	
	public List<Contact> getContacts(){
		List<Contact> contacts = new ArrayList<Contact>();
		Contact contact = new Contact();
		contact.setId(1);
		contacts.add(contact);
		return contacts;
	}
	
	public User getUser(){
		User user = new User();
		user.setId(1);
		return user;
	}
    
}