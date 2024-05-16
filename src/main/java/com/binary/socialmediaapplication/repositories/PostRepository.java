package com.binary.socialmediaapplication.repositories;

import com.binary.socialmediaapplication.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
   private List<Post> posts = new ArrayList<>();
   private int idCount=1;
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


       this.addPost(post1);
       this.addPost(post2);
       this.addPost(post3);

   }

   public void addPost(Post post){
       post.setId(idCount);
       posts.add(post);
       idCount++;
   }

   public List<Post> getAllPosts(){
       return posts;
   }


   public Optional<Post> getPostbyId(int id){
      return  posts.stream().filter((post -> post.getId() == id)).findFirst();
   }


    public void update(Post updatedPost) {

       for(int i =0; i <posts.size(); i++){
           if(posts.get(i).getId().equals(updatedPost.getId())){
               posts.set(i, updatedPost);
               break;
           }
       }

    }
}
