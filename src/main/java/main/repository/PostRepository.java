package main.repository;

import main.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.HashSet;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    String query = "SELECT " +
            "* " +
            "FROM Post p ";
    String where = "WHERE p.is_active = 1 " +
            " AND p.moderation_status = 'ACCEPTED' " +
            " AND p.time <= :date";

    String fullQuery = query + where;

    @Query(fullQuery)
    HashSet<Post> getPost(@Param("date") Instant date);


}
