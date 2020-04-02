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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Posts post;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="tag_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Tag tag;
}
