package com.binary.socialmediaapplication.services;

import com.binary.socialmediaapplication.models.Post;
import com.binary.socialmediaapplication.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

 public Optional<Post> findById(int id){

     return repository.getPostbyId(id);
 }

 public void updatePost(Post updatedPost){
     repository.update(updatedPost);
 }

 public void deletePostById(Integer id){
       repository.removePostbyId(id);
 }

}
