package main.repository;

import main.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    String query = "SELECT" +
            " p" +
            " FROM Post p ";

    String where = "WHERE p.isActive = 1 " +
            " AND p.moderationStatus = 'ACCEPTED' " +
            " AND p.time <= :data";

    String group = " GROUP BY p.id";

    String fullQuery = query + where + group;

    @Query(fullQuery)
    List<Post> find(@Param("data")Instant date);
}
