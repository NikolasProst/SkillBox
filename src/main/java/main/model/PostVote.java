package main.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 *  Лайки и дизлайки постов
 */
@Data
@Entity
@Table(name = "post_votes")
public class PostVote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    /** тот, кто поставил лайк / дизлайк */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false, updatable = false)
    private User user;

    /** пост, которому поставлен лайк / дизлайк */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Posts post;

    /** дата и время лайка / дизлайка */
    @Column(name = "time", nullable = false)
    private Date time;

    /** лайк или дизлайк: 1 или -1 */
    @Column(name = "value", nullable = false)
    private int value;
}
