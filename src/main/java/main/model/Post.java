package main.model;
import lombok.Data;
import main.enums.ModerationStatus;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status", nullable = false)
    private ModerationStatus moderationStatus;
    @Column(name = "moderator_id",nullable = true)
    private int moderatorId;
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "time", nullable = false)
    private Date time;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "view_count", nullable = false)
    private int viewCount;

}
