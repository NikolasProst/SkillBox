package main.DTO;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import main.JsonViews;
import main.model.PostComment;
import main.model.Tag;

import java.util.Date;

import java.util.List;

@Data

public class PostsDTO {
    @JsonView(JsonViews.post.class)
    private int id;

    @JsonView(JsonViews.post.class)
    private Date time;

    @JsonView(JsonViews.post.class)
    private PostAuthorDTO user;

    @JsonView(JsonViews.post.class)
    private String title;

    @JsonView(JsonViews.post.class)
    private String announce;

    @JsonView(JsonViews.post.class)
    private int likeCount;

    @JsonView(JsonViews.post.class)
    private int dislikeCount;

    @JsonView(JsonViews.post.class)
    private int commentCount;

    @JsonView(JsonViews.post.class)
    private int viewCount;

    @JsonView(JsonViews.idPost.class)
    private List<PostComment> comments;

    @JsonView(JsonViews.idPost.class)
    private List<Tag> tags;

    public PostsDTO() { }
}
