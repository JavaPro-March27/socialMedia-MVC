package com.binary.socialmediaapplication.repositories;

import com.binary.socialmediaapplication.models.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {

    List<Comment> comments = new ArrayList<>();
    private  Integer idCount=100;

    public CommentRepository(){
        Comment comment1 = new Comment();
                comment1.setCommentMessage("Hey its nice post!");
                comment1.setAuthorName("hemanth");

        Comment comment2 = new Comment();
        comment2.setCommentMessage("Hey ok ok post!");
        comment2.setAuthorName("hemanth");

        Comment comment3 = new Comment();
        comment3.setCommentMessage("Hey bad post!");
        comment3.setAuthorName("hemanth");

        this.addComment(1, comment1);
        this.addComment(2, comment2);
        this.addComment(3, comment3);

    }


    public void addComment(int postId, Comment comment){
        comment.setPostId(postId);
        comments.add(comment);
        idCount++;
    }

    public List<Comment> getAllCommentsByPostId(int postId){

           return comments.stream()
                          .filter(post -> post.getPostId() == postId)
                          .collect(Collectors.toList());
    }



}
