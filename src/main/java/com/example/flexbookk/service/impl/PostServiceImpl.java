package com.example.flexbookk.service.impl;

import com.example.flexbookk.model.Post;
import com.example.flexbookk.repository.PostRepository;
import com.example.flexbookk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }
}
