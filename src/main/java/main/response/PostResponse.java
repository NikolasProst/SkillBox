package main.response;

import lombok.Data;

@Data
public class PostResponse {
    private int count;
    private PostsResponse posts;
}
