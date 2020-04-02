package main.model;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import main.JsonViews;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    @JsonView(JsonViews.post.class)
    private int id;

    @Column(name = "is_moderator",nullable = false)
    private boolean isModerator;

    @Column(name = "reg_time",nullable = false)
    private Date regTime;

    @JsonView(JsonViews.post.class)
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false, length = 255)
    private String email;

    @Column(name = "password",nullable = false, length = 255)
    private String password;

    /** код для восстановления пароля, может быть NULL */
    @Column(name = "code",nullable = true, length = 255)
    private String code;

    /** фотография (ссылка на файл), может быть NULL */
    @JsonView(JsonViews.post.class)
    @Column(name = "photo",nullable = true, length = 255)
    private String photo;
}
