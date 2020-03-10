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
    @Column(name = "user_id", nullable = false)
    private int userId;

    /** пост, которому поставлен лайк / дизлайк */
    @Column(name = "post_id", nullable = false)
    private int postId;

    /** дата и время лайка / дизлайка */
    @Column(name = "time", nullable = false)
    private Date time;

    /** лайк или дизлайк: 1 или -1 */
    @Column(name = "value", nullable = false)
    private boolean value;
}
