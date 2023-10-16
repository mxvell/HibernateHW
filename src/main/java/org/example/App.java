package org.example;


import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try  {
            session.beginTransaction();
            Director director = session.get(Director.class, 1);
            System.out.println(director.getName());

            List<Movie>movies = director.getMovies();

            for (Movie movie : movies){
                System.out.println(movie);
            }


            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
