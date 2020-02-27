package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    @Column(name = "moderationStatus", nullable = false)
    private ModerationStatus moderationStatus;
    @Column(name = "moderatorId",nullable = true)
    private int moderatorId;
    @Column(name = "userId", nullable = false)
    private int userId;
    @Column(name = "time", nullable = false)
    private Date time;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "test", nullable = false)
    private String test;
    @Column(name = "viewCount", nullable = false)
    private int viewCount;

    public enum ModerationStatus {
        NEW,
        ACCEPTED,
        DECLINED
    }
}
