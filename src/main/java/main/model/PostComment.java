package main.model;

import javax.persistence.*;
import java.util.Date;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
}
