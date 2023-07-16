package com.geekster.InstaGram_basic_design.controller;

import com.geekster.InstaGram_basic_design.model.Post;
import com.geekster.InstaGram_basic_design.service.AuthenticationService;
import com.geekster.InstaGram_basic_design.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/create")
    public String createInstaPost(@RequestBody Post post, @RequestParam String email, @RequestParam String token) {
        if (authenticationService.authenticate(email, token)) {
            return postService.createInstaPost(post, email);
        } else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }
}
