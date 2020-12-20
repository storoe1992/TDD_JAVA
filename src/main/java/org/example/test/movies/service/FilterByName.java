package org.example.test.movies.service;

import org.example.test.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class FilterByName implements MovieFilterChainResponsability{

    private MovieFilterChainResponsability movieFilterChainResponsability;

    public FilterByName() {}

    public FilterByName(MovieFilterChainResponsability movieFilterChainResponsability) {
        this.movieFilterChainResponsability = movieFilterChainResponsability;
    }


    @Override
    public Collection<Movie> apply(Movie movie, Collection<Movie> movies) {
        Collection<Movie> temp = movies;
        if(movie.getName()!=null)
            temp = movies.stream().filter(mov -> mov.getName().toLowerCase().contains(movie.getName().toLowerCase())).collect(Collectors.toList());
        return movieFilterChainResponsability == null ? temp : movieFilterChainResponsability.apply(movie,temp);
    }
}
