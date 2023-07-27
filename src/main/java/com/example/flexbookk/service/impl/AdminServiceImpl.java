package com.example.flexbookk.service.impl;

import com.example.flexbookk.model.Post;
import com.example.flexbookk.model.User;
import com.example.flexbookk.repository.PostRepository;
import com.example.flexbookk.repository.UserRepository;
import com.example.flexbookk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getLogin(String username, String password) {

        return userRepository.findUserByUsernameAndPassword(username, password);
    }
}
