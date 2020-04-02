package main.controllers;

import com.fasterxml.jackson.annotation.JsonView;

import main.JsonViews;
import main.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {

    @Autowired
    private PostService postService;


    @GetMapping(value = "")
    @JsonView(JsonViews.post.class)
    public ResponseEntity getPosts(@RequestParam(name = "offset") int offset, @RequestParam(name = "limit") int limit, @RequestParam(name = "mode") String mode) {
        return postService.getAll(offset, limit, mode);
    }

    @GetMapping(value = "/search")
    @JsonView(JsonViews.post.class)
    public ResponseEntity searchPost(@RequestParam(name = "offset") int offset, @RequestParam(name = "limit") int limit, @RequestParam(name = "query") String query) {
        return postService.search(offset, limit, query);
    }

    @GetMapping(value = "/{id}")
    @JsonView(JsonViews.idPost.class)
    public ResponseEntity getPostbyId(@PathVariable int id) {
        return postService.getPostbyId(id);
    }

}
