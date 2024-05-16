package com.binary.socialmediaapplication.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {

    private Integer id;
    private String commentMessage;
    private String authorName;
    private Integer postId;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
