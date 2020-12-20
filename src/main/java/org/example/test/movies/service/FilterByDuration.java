package org.example.test.movies.service;

import org.example.test.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class FilterByDuration implements MovieFilterChainResponsability{

    private MovieFilterChainResponsability movieFilterChainResponsability;

    public FilterByDuration(MovieFilterChainResponsability movieFilterChainResponsability) {
        this.movieFilterChainResponsability = movieFilterChainResponsability;
    }

    public FilterByDuration() {
    }

    @Override
    public Collection<Movie> apply(Movie movie, Collection<Movie> movies) {
        Collection<Movie> temp = movies;
        if(movie.getMinutes()!=null) {
            if(movie.getMinutes() < 0)
                throw new IllegalArgumentException("Duration can't be negative");
            temp = movies.stream().filter(mov -> mov.getMinutes() <= movie.getMinutes()).collect(Collectors.toList());
        }
        return movieFilterChainResponsability == null ? temp : movieFilterChainResponsability.apply(movie,temp);
    }
}
