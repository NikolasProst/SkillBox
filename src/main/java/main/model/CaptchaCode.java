package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "CaptchaCodes")
public class CaptchaCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "time", nullable = false)
    private Date time;
    @Column(name = "code", nullable = false)
    private  String code;
    @Column(name = "secretCode", nullable = false)
    private String secretCode;
}