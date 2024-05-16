package com.binary.socialmediaapplication.services;

import com.binary.socialmediaapplication.models.Comment;
import com.binary.socialmediaapplication.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public List<Comment> getAllCommentsByPostId(int postId){
        return commentRepository.getAllCommentsByPostId(postId);
    }

}
