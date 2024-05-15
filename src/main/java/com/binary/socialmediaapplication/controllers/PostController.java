package com.binary.socialmediaapplication.controllers;

import com.binary.socialmediaapplication.models.Post;
import com.binary.socialmediaapplication.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String createPost(@ModelAttribute("newPost") @Valid Post newPost, BindingResult result, Errors errors){

        if(errors.hasErrors()){
            return "posts/createPostPage";
        }
         postService.addPost(newPost);
        return "redirect:/posts/list";
    }


}
