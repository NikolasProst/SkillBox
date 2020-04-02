package main.model;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import main.JsonViews;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "post_comments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    @JsonView(JsonViews.post.class)
    private int id;

    @ManyToOne
    @JoinColumn(name="parent_id", nullable = true, referencedColumnName = "id")
    private PostComment parentComment;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Posts post;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false, updatable = false)
    @JsonView(JsonViews.post.class)
    private User user;

    @Column(name = "text", nullable = false)
    @JsonView(JsonViews.post.class)
    private String text;

    @Column(name = "time", nullable = false)
    @JsonView(JsonViews.post.class)
    private Date time;

}
