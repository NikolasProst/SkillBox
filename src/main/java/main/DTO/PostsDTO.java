package main.DTO;

import lombok.Data;
import main.model.Posts;


import java.util.Date;

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

    public PostsDTO(Posts post, int likeCount, int dislikeCount, int commentCount) {
        this.id = post.getId();
        this.time = post.getTime();
        this.user = new PostAuthorDTO(post.getAuthor().getId());
        this.title = post.getTitle();
        this.announce = post.getText().substring(0, 50);
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.commentCount = commentCount;
        this.viewCount = post.getViewCount();
    }
}
