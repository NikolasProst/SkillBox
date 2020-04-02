package main.model;
import com.sun.istack.NotNull;
import lombok.Data;
import main.enums.ModerationStatus;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status", nullable = false)
    private ModerationStatus moderationStatus;

    /** ID пользователя, принявшего решение, или NULL */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "moderator_id", referencedColumnName="id")
    private User moderatedBy;

    /** Автор поста */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName="id")
    private User author;

    @Column(name = "time", nullable = false)
    private Date time;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "view_count" +
            "", nullable = false)
    private int viewCount;

}
