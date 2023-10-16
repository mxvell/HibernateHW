package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "Movie")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_production")
    private int year_of_production;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director directorOwner;

    public Movie(String name, int year_of_production) {
        this.name = name;
        this.year_of_production = year_of_production;
    }
}
