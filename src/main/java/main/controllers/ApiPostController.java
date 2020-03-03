package main.controllers;

import main.repository.PostRepository;
import main.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {

    private PostRepository postRepository;

    @GetMapping(value = "/")
    public ResponseEntity getPosts(@RequestParam(name = "offset") int offset, @RequestParam(name = "limit") int limit, @RequestParam(name = "mode") String mode) {
        HashSet<Post> posts = postRepository.getPost();
        return new ResponseEntity(posts, HttpStatus.OK);
    }
}
