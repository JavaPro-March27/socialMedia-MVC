package com.binary.socialmediaapplication.controllers;

import com.binary.socialmediaapplication.models.Post;
import com.binary.socialmediaapplication.services.CommentService;
import com.binary.socialmediaapplication.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

   private final PostService postService;

    @GetMapping({"", "/list", "/postslist"})
    public String postPage(Model model){

        model.addAttribute("posts", postService.findAllPosts());
      return "posts/postIndex";
    }

    @GetMapping("/create")
    public String createPostPage(Model  model){
        model.addAttribute("newPost", new Post());
        return "posts/createPostPage";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("newPost") @Valid Post newPost, Errors errors){

        if(errors.hasErrors()){
            return "posts/createPostPage";
        }
         postService.addPost(newPost);
        return "redirect:/posts/list";
    }

    @GetMapping("/update/{id}")
    public String updatePostPage(@PathVariable("id") Integer id,  Model model){

        Optional<Post> optionalPost = postService.findById(id);
        Post updatedpost=null;
        if(optionalPost.isPresent()) {
            updatedpost = optionalPost.get();
        }else {
            return "redirect:/posts/list";
        }

        model.addAttribute("postNeedToUpdate", updatedpost);
        System.out.println(updatedpost);
        return "posts/updatePostPage";
    }


    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Integer id, @ModelAttribute("postNeedToUpdate") @Valid Post updatedPost, Errors errors){

        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
            return "posts/updatePostPage";
        }
        System.out.println(updatedPost);
        postService.updatePost(updatedPost);

        return "redirect:/posts/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePostPage(@PathVariable("id") Integer id, Model model){

        return "posts/deletePostPage";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id){

       postService.deletePostById(id);

       return "redirect:/posts/list";
    }


}
