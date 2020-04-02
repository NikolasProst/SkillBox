package main.DTO;


import lombok.Data;
import main.model.PostComment;
import main.model.Tag;

import java.util.Date;

import java.util.List;

@Data
public class PostsDTO {
    private int id;
    private Date time;
    private PostAuthorDTO user;
    private String title;
    private String announce;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;
    private int viewCount;

   private List<PostComment> comments;
   private List<Tag> tags;

    public PostsDTO() { }
}
