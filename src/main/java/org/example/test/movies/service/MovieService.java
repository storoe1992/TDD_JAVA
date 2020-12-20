package org.example.test.movies.service;

import org.example.test.movies.data.MovieRepository;
import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection <Movie> findMoviesByGenre(Genre genre) {
        Collection <Movie> all = movieRepository.findAll();
        Movie template = new Movie(null, null, null, genre, null);
        return new FilterByGenre().apply(template,all);
    }

    public Collection<Movie> findMoviesByLenght(int duration) {
        Collection <Movie> all = movieRepository.findAll();
        Movie template = new Movie(null, null, duration, null, null);
        return new FilterByDuration().apply(template,all);
    }

    public Collection<Movie> findMoviesByName(String name) {
        Collection <Movie> all = movieRepository.findAll();
        Movie template = new Movie(null, name, null, null, null);
        return new FilterByName().apply(template,all);
    }

    public Collection<Movie> findMoviesByDirector(String directorName) {
        Collection <Movie> all = movieRepository.findAll();
        Movie template = new Movie(null, null, null, null, directorName);
        return new FilterByNameDirector().apply(template,all);
    }

    public Collection<Movie> findMoviesByTemplate(Movie movie) {
        Collection <Movie> all = movieRepository.findAll();
        MovieFilterChainResponsability filterByDuration = new FilterByDuration();
        MovieFilterChainResponsability filterByGenre = new FilterByGenre(filterByDuration);
        MovieFilterChainResponsability filterByName = new FilterByName(filterByGenre);
        MovieFilterChainResponsability filterByDirector = new FilterByNameDirector(filterByName);
        MovieFilterChainResponsability filterById = new FilterById(filterByDirector);
        return filterById.apply(movie,all);
    }
}
