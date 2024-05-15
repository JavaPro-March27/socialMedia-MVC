package com.binary.socialmediaapplication.services;

import com.binary.socialmediaapplication.models.Post;
import com.binary.socialmediaapplication.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
 private final PostRepository repository;

 public void addPost(Post post){
     repository.addPost(post);
 }

 public List<Post> findAllPosts(){
     return repository.getAllPosts();
 }

}
