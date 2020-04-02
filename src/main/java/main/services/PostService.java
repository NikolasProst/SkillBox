package main.services;

import main.DTO.PostAuthorDTO;
import main.DTO.PostListDTO;
import main.DTO.PostsDTO;
import main.PageRequest;
import main.enums.PostViewMode;
import main.model.Posts;
import main.repository.PostRepository;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

        Pageable pageable = new PageRequest(offset, limit, sort);
        Page<Posts> posts =  posts = postRepository.findAll(pageable);

        switch (viewMode) {
            case BEST:
                /**по убыванию количества лайков*/
                posts = new PageImpl(posts.stream()
                        .sorted(Comparator.comparing(Posts::getLikeCount).reversed())
                        .collect(Collectors.toList()));
                break;
            case EARLY:
                /** сначала старые */
                posts = new PageImpl(posts.stream()
                        .sorted(Comparator.comparing(Posts::getTime))
                        .collect(Collectors.toList()));
                break;
            case RECENT:
                /** сначала новые - стоит по умолчанию */
                break;
            case POPULAR:
                /** по убыванию количества комментариев */
                posts = new PageImpl(posts.stream()
                        .sorted(Comparator.comparing(Posts::getCountComments).reversed())
                        .collect(Collectors.toList()));
                break;
            default:
                break;
        }
        return ResponseEntity.ok(new PostListDTO(new PageImpl(posts.stream()
                .map(this::convertToDto).collect(Collectors.toList()))));
    }

    /** Поиск постов по тексту */
    public ResponseEntity search(int offset, int limit, String query) {
        Sort sort = Sort.by(Sort.Direction.DESC, "time");
        Pageable pageable = new PageRequest(offset, limit, sort);
        Page<Posts> posts = postRepository.findAllByQuery(query, pageable);
        return ResponseEntity.ok(new PostListDTO(new PageImpl(posts.stream()
                .map(this::convertToDto).collect(Collectors.toList()))));
    }

    /**Перевод постов в DTO**/
    private PostsDTO convertToDto(Posts post) {
        PostsDTO postDto = modelMapper.map(post, PostsDTO.class);
        postDto.setUser(new PostAuthorDTO(post.getAuthor().getId(), post.getAuthor().getName()));
        postDto.setAnnounce(Jsoup.clean(post.getText(), Whitelist.none()));
        postDto.setLikeCount((int)post.getPostVotes().stream().map(v -> v.getValue()).filter(v -> v > 0).count());
        postDto.setDislikeCount((int)post.getPostVotes().stream().map(v -> v.getValue()).filter(v -> v < 0).count());
        postDto.setCommentCount((int)post.getPostComments().stream().count());
        return postDto;
    }
}
