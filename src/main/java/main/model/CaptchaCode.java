package main.model;

import javax.persistence.*;
import java.util.Date;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
}
