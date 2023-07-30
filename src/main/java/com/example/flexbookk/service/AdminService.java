package com.example.flexbookk.service;

import com.example.flexbookk.model.Post;
import com.example.flexbookk.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    User getLogin(String username, String password);
}
