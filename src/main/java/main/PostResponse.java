package main;

import lombok.Data;
import main.model.Post;

@Data
public class PostResponse {
    private int count;
    private Post post;



}
