package main.repository;

import main.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {
    String query = "SELECT * FROM Posts LEFT JOIN Votes v ON Posts.id = Votes.post_id";

    String where = "WHERE Posts.isActive = 1 " +
            " AND Posts.moderationStatus = 'ACCEPTED' " +
            " AND Posts.time <= CURRENT_TIMESTAMP()";

    String group = " GROUP BY Posts.id";

    String fullQuery = query + where + group;

    @Query(value = fullQuery, nativeQuery = true)
    Page<Posts> findAll(Pageable pageable);

    @Query(value ="SELECT * FROM Posts LEFT JOIN Post_comment ON Posts.id = Post_comment.post_id" + where + group, nativeQuery = true)
    Page<Posts> findAllWithCommentCount(Pageable pageable);

    @Query(value = "SELECT * FROM Posts " + where + " AND (Posts.title LIKE %:query% OR Posts.text LIKE %:query%)" + group, nativeQuery = true)
    Page<Posts> findAllByQuery(@Param("query") String query, Pageable pageable);
}
