package org.example.test.movies.data;

import org.example.test.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);
    Collection <Movie> findAll();
    void saveOrUpdate(Movie movie);
}
