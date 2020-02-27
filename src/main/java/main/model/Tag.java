package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
}
