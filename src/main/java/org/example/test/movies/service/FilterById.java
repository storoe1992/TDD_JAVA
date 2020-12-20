package org.example.test.movies.service;

import org.example.test.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class FilterById implements MovieFilterChainResponsability{


    private MovieFilterChainResponsability movieFilterChainResponsability;

    public FilterById(MovieFilterChainResponsability movieFilterChainResponsability) {
        this.movieFilterChainResponsability = movieFilterChainResponsability;
    }

    public FilterById() {
    }

    @Override
    public Collection<Movie> apply(Movie movie,Collection <Movie> movieList) {
        if(movie.getId()!=null)
            return movieList.stream().filter(mov -> mov.getId() == movie.getId()).collect(Collectors.toList());
        return movieFilterChainResponsability == null ? movieList : movieFilterChainResponsability.apply(movie,movieList);
    }
}
