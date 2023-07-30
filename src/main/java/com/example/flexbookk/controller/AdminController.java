package com.example.flexbookk.controller;

import com.example.flexbookk.model.Post;
import com.example.flexbookk.model.User;
import com.example.flexbookk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public User login(@RequestParam String username, String password) {
        return adminService.getLogin(username, password);
    }

}
