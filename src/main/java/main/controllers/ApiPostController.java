package main.controllers;

import main.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {

    private PostService postService;

    @GetMapping(value = "/")
    public ResponseEntity getPosts(@RequestParam(name = "offset") int offset, @RequestParam(name = "limit") int limit, @RequestParam(name = "mode") String mode) {
        return postService.getAll(0, 10, "best");
    }

    @GetMapping(value = "/search/")
    public ResponseEntity searchPost(@RequestParam(name = "offset") int offset, @RequestParam(name = "limit") int limit, @RequestParam(name = "query") String query) {
        return postService.search(offset, limit, query);
    }
}
