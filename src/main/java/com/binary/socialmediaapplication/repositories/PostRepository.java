package com.binary.socialmediaapplication.repositories;

import com.binary.socialmediaapplication.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
   private final List<Post> posts = new ArrayList<>();

   public PostRepository(){
       Post post1 = new Post();
       post1.setTitle("Hello Spring MVC");
       post1.setDescription("Starting SpringMVC");
       post1.setBody("SpringBoot is fun");

       Post post2 = new Post();
       post2.setTitle("Hey Lets go for a movie");
       post2.setDescription("Lord of the rings");
       post2.setBody("Good movie");

       Post post3 = new Post();
       post3.setTitle("Lets party");
       post3.setDescription("Do on long weekend");
       post3.setBody("Plan it");

       posts.add(post1);
       posts.add(post2);
       posts.add(post3);
   }

   public void addPost(Post post){
       posts.add(post);
   }

   public List<Post> getAllPosts(){
       return posts;
   }

}
