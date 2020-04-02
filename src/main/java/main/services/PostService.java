package main.services;

import main.DTO.PostListDTO;
import main.DTO.PostsDTO;
import main.PageRequest;
import main.enums.PostViewMode;
import main.model.Posts;
import main.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

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
        Page<Posts> posts =  posts = postRepository.findAll(pageable);;
        if (viewMode == PostViewMode.POPULAR) {
            posts = postRepository.findAllWithCommentCount(pageable);
        }
        return ResponseEntity.ok(new PostListDTO(new PageImpl(posts.stream()
                .map(this::convertToDto).collect(Collectors.toList()))));
    }


    public ResponseEntity search(int offset, int limit, String query) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable pageable = new PageRequest(offset, limit, sort);
        Page<Posts> posts = postRepository.findAllByQuery(query, pageable);
        return ResponseEntity.ok(new PostListDTO(posts));
    }

    private PostsDTO convertToDto(Posts post) {
        PostsDTO postDto = modelMapper.map(post, PostsDTO.class);
        return postDto;
    }
}
