package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GlobalSettings")
public class GlobalSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "code",nullable = false, length = 255)
    private String code;
    @Column(name = "name",nullable = false, length = 255)
    private String name;
    @Column(name = "value",nullable = false, length = 255)
    private String value;
}
