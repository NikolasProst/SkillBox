package main.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "is_moderator",nullable = false)
    private boolean isModerator;
    @Column(name = "reg_time",nullable = false)
    private Date regTime;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email",nullable = false, length = 255)
    private String email;
    @Column(name = "password",nullable = false, length = 255)
    private String password;
    @Column(name = "code",nullable = true, length = 255)
    private String code;
    @Column(name = "photo",nullable = true, length = 255)
    private String photo;
}
