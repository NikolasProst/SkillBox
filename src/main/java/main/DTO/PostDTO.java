package main.DTO;

import lombok.Data;
import main.model.Post;

import java.util.Date;

@Data
public class PostDTO {
    private int id;
    private Date time;
    private UserDTO user;
    private String title;
    private String announce;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;
    private int viewCount;

    public PostDTO(Post post, int likeCount, int dislikeCount, int commentCount) {
        this.id = post.getId();
        this.time = post.getTime();
        this.user = new UserDTO(post.getAuthor().getId());
        this.title = post.getTitle();
        this.announce = post.getText().substring(0, 50);
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.commentCount = commentCount;
        this.viewCount = post.getViewCount();
    }
}
