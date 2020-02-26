package main.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postVotes")
public class PostVote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "userId", nullable = false)
    private int userId;
    @Column(name = "postId", nullable = false)
    private int postId;
    @Column(name = "time", nullable = false)
    private Date time;
    @Column(name = "value", nullable = false)
    private boolean value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
