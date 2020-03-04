package main.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "post_votes")
public class PostVote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "post_id", nullable = false)
    private int postId;
    @Column(name = "time", nullable = false)
    private Date time;
    @Column(name = "value", nullable = false)
    private boolean value;
}
