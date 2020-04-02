package main.model;
import lombok.Data;
import main.enums.ModerationStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

    @Column(name = "view_count", nullable = false)
    private int viewCount;

    /** Лайки поста */
    @OneToMany
    @JoinColumn(name = "post_id")
    private List<PostVote> postVotes;

    /** Комментарии поста */
    @OneToMany
    @JoinColumn(name = "post_id")
    private List<PostComment> postComments;

    @ManyToMany
    @JoinTable(name = "tags",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName="id"))
    private List<Tag2Post> postTags;

    public int getCountComments(){ return postComments.size(); }

    public int getLikeCount() {return (int) postVotes.stream().map(v -> v.getValue()).filter(v -> v > 0).count();}
}
