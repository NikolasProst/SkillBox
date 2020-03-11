package main.services;

import main.DTO.PostListDTO;
import main.PageRequest;
import main.enums.PostViewMode;
import main.model.Post;
import main.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public ResponseEntity getAll(int offset, int limit, String mode) {
        PostViewMode viewMode = null;
        Sort sort = Sort.by(Sort.Direction.DESC, "time");

        try {
            viewMode = PostViewMode.getByName(mode);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        switch (viewMode) {
            case BEST:
                sort = Sort.by(Sort.Direction.DESC, "like_count");
                break;
            case EARLY:
                sort = Sort.by(Sort.Direction.ASC, "time");
                break;
            case RECENT:
                /** стоит по умолчанию */
                break;
            case POPULAR:
                sort = Sort.by(Sort.Direction.DESC, "comment_сount");
                break;
            default:
                break;
        }
        Pageable pageable = new PageRequest(offset, limit, sort);
        Page<Post> posts = null;
        if (viewMode == PostViewMode.POPULAR) {
            posts = postRepository.findAllWithCommentCount(Instant.now(), pageable);
        }
        else {
            posts = postRepository.findAll(Instant.now(), pageable);
        }
        return ResponseEntity.ok(new PostListDTO(posts));
    }


    public ResponseEntity search(int offset, int limit, String query) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable pageable = new PageRequest(offset, limit, sort);
        Page<Post> posts = postRepository.findAllByQuery(Instant.now(), query, pageable);
        return ResponseEntity.ok(new PostListDTO(posts));
    }
}
