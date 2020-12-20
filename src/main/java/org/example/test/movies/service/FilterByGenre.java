package org.example.test.movies.service;

import org.example.test.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class FilterByGenre implements MovieFilterChainResponsability{

    private MovieFilterChainResponsability movieFilterChainResponsability;

    public FilterByGenre(MovieFilterChainResponsability movieFilterChainResponsability) {
        this.movieFilterChainResponsability = movieFilterChainResponsability;
    }

    public FilterByGenre() {
    }

    @Override
    public Collection<Movie> apply(Movie movie, Collection<Movie> movies) {
        Collection<Movie> temp = movies;
        if(movie.getGenre()!=null)
            temp = movies.stream().filter(mov -> mov.getGenre() == movie.getGenre()).collect(Collectors.toList());
        return movieFilterChainResponsability == null ? temp : movieFilterChainResponsability.apply(movie,temp);
    }
}
