package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Table(name = "Director")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @OneToMany(mappedBy = "directorOwner")
    private List<Movie> movies;
}
