package com.geekster.InstaGram_basic_design.service;

import com.geekster.InstaGram_basic_design.model.Post;
import com.geekster.InstaGram_basic_design.model.User;
import com.geekster.InstaGram_basic_design.repository.PostRepo;
import com.geekster.InstaGram_basic_design.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    public String createInstaPost(Post post, String email) {
        User postOwner = userRepo.findFirstByEmail(email);
        if (postOwner != null) {
            post.setUser(postOwner);
            post.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            post.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
            postRepo.save(post);
            return "Post Uploaded!";
        } else {
            return "User not found!";
        }
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }
}

