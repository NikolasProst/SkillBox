package main.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

public class PostListDTO {
    @Getter
    private final long count;

    @Getter @Setter
    private List<PostsDTO> posts;

    public PostListDTO(Page posts) {
        this.posts = posts.getContent();
        this.count = posts.getTotalElements();
    }
}
