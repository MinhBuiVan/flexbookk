package com.example.flexbookk.controller;

import com.example.flexbookk.model.Post;
import com.example.flexbookk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
