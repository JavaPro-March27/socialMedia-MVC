package com.binary.socialmediaapplication.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    private Integer id;

    @NotNull(message = "The title is required")
    @Size(min = 3, max = 50)
    private String title;
    @NotNull(message = "The description is required")
    @Size(min = 3, max = 50)
    private String description;
    @NotNull
    @Size(min =10, message = "The body should be at least 10 characters")
    @Size(max =100, message = "The body should not exceeded  100 characters")
    private String body;
    private String postStatus ;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<Comment> comments;

}
