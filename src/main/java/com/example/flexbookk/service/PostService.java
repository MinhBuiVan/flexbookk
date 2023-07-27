package com.example.flexbookk.service;

import com.example.flexbookk.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> getAllPosts();
}
