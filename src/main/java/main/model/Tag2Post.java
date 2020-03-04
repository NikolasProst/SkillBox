package main.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tag_2_posts")
public class Tag2Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "post_id", nullable = false)
    private int postId;
    @Column(name = "tag_id", nullable = false)
    private int tagId;
}
