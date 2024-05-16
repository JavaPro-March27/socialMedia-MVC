package com.binary.socialmediaapplication.services;

import com.binary.socialmediaapplication.models.Comment;
import com.binary.socialmediaapplication.models.Post;
import com.binary.socialmediaapplication.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
 private final PostRepository repository;
 private final CommentService commentService;

 public void addPost(Post post){
     repository.addPost(post);
 }

 public List<Post> findAllPosts(){
       List<Post> posts= repository.getAllPosts();
//       posts.stream().map(post->{
//           post.setComments(commentService.getAllCommentsByPostId(post.getId()));
//           return post;
//       }).collect(Collectors.toList());

     for(int i=0; i<posts.size();i++){
         Post post = posts.get(i);
         List<Comment> comments = commentService.getAllCommentsByPostId(post.getId());
         post.setComments(comments);
     }

     return posts;
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
