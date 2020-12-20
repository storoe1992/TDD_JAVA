package org.example.test.movies.service;


import org.example.test.movies.model.Movie;

import java.util.Collection;

public interface MovieFilterChainResponsability {

    Collection <Movie> apply(Movie movie,Collection <Movie> movies);
}
