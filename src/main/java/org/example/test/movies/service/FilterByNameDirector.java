package org.example.test.movies.service;

import org.example.test.movies.model.Movie;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FilterByNameDirector implements MovieFilterChainResponsability{

    private MovieFilterChainResponsability movieFilterChainResponsability;

    public FilterByNameDirector(MovieFilterChainResponsability movieFilterChainResponsability) {
        this.movieFilterChainResponsability = movieFilterChainResponsability;
    }

    public FilterByNameDirector() {
    }

    @Override
    public Collection <Movie> apply(Movie movie, Collection <Movie> movieList) {
        Collection <Movie> temp = movieList;
        if(movie.getDirector()!=null)
            temp = movieList.stream().filter(mov -> mov.getDirector().toLowerCase().contains(movie.getDirector().toLowerCase())).collect(Collectors.toList());
        return movieFilterChainResponsability == null ? temp : movieFilterChainResponsability.apply(movie,temp);
    }
}
