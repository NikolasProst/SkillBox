package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "PostComments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "parentId", nullable = true)
    private int parentId;
    @Column(name = "postId", nullable = false)
    private int postId;
    @Column(name = "userId", nullable = false)
    private int userId;
    @Column(name = "time", nullable = false)
    private Date time;

}
