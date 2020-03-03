package main.repository;

import main.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    String nameQuery = "SELECT u.name " +
            "FROM User u WHERE u.id = :id";

    @Query(nameQuery)
    String findById(@Param("id") int id);
}
