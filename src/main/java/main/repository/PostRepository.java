package main.repository;

import main.DTO.PostDTO;
import main.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    /**Выборка с общим количеством лайков и дислайков*/
    String query = "SELECT" +
            " *, SUM(v.value = 1 THEN 1 ELSE 0 END) as like_count, +" +
            " SUM(CASE WHEN v.value = -1 THEN 1 ELSE 0 END)" +
            " FROM Post p LEFT JOIN Votes v ON p.id = v.post_id";

    String where = "WHERE p.isActive = 1 " +
            " AND p.moderationStatus = 'ACCEPTED' " +
            " AND p.time <= :date";

    String group = " GROUP BY p.id";

    String fullQuery = query + where + group;

    @Query(value = fullQuery, nativeQuery = true)
    Page<Post> findAll(@Param("date")Instant date, Pageable pageable);

    @Query(value ="SELECT" + " *, COUNT(pc.id) FROM Post p LEFT JOIN Post_comment pc ON p.id = pc.post_id" + where + group, nativeQuery = true)
    Page<Post> findAllWithCommentCount(@Param("date")Instant date, Pageable pageable);

    @Query(value = "SELECT p FROM Post p " + where + " AND (p.title LIKE %:query% OR p.text LIKE %:query%) GROUP BY p.id", nativeQuery = true)
    Page<Post> findAllByQuery(@Param("date")Instant date, @Param("query") String query, Pageable pageable);
}
