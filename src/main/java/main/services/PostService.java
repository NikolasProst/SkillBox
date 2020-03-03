package main.services;

import main.enums.PostViewMode;
import main.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public ResponseEntity getAll(int offset, int limit, String mode) {
        PostViewMode viewMode;
        Instant today = Instant.now();
        /*Найти методы сортировки*/
        try {
            viewMode = PostViewMode.getByName(mode);
            switch (viewMode) {
                case BEST:
                    break;
                case EARLY:
                    break;
                case RECENT:
                    break;
                case POPULAR:
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        /*Придумать как получить нужный массив*/
        //PostsResponse postsResponse = new PostsResponse(postRepository.findAll(), 0, 0, 0);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
