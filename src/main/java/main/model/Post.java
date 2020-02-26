package main.model;

import javax.persistence.*;
import java.util.Date;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ModerationStatus getModerationStatus() {
        return moderationStatus;
    }

    public void setModerationStatus(ModerationStatus moderationStatus) {
        this.moderationStatus = moderationStatus;
    }

    public int getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(int moderatorId) {
        this.moderatorId = moderatorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
