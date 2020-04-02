package main.repository;

import main.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {

    String query = "SELECT *" +
            " FROM posts as p";
    String where = " WHERE p.is_active = 1" +
            " AND p.moderation_status = 'ACCEPTED'" +
            " AND p.time <= CURRENT_TIMESTAMP()";

    String group = " GROUP BY p.id";

    String fullQuery = query + where + group;

    @Query(value = fullQuery, nativeQuery = true)
    Page<Posts> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM Posts " + where + " AND (Posts.title LIKE %:query% OR Posts.text LIKE %:query%)" + group, nativeQuery = true)
    Page<Posts> findAllByQuery(@Param("query") String query, Pageable pageable);

    Posts findById(@Param("id") int id);

    @Query(value = query + where + " AND DATE_FORMAT(p.time, '%Y-%m-%d') = :date" + group, nativeQuery = true)
    Page<Posts> findAllByTime(@Param("date") String date, Pageable pageable);

}
