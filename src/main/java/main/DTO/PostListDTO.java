package main.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import main.JsonViews;
import org.springframework.data.domain.Page;

import java.util.List;

public class PostListDTO {
    @Getter
    @JsonView(JsonViews.post.class)
    private final long count;

    @Getter @Setter
    @JsonView(JsonViews.post.class)
    private List<PostsDTO> posts;

    public PostListDTO(Page posts) {
        this.posts = posts.getContent();
        this.count = posts.getTotalElements();
    }
}
