package com.leo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.model.User;
import com.leo.repository.UserRepository;


@Service
public class UserService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Transactional(readOnly=true)
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}