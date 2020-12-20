package org.example.test.movies.service;

import org.example.test.movies.data.MovieRepository;
import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class MovieServiceTest {

    private MovieRepository movieRepository;
    private MovieService movieService;

    @Before
    public void setUp() {
        movieRepository = Mockito.mock(MovieRepository.class);
        when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1,"Dark Knight",152,Genre.ACTION,"director2"),
                new Movie(2,"Memento",113,Genre.THRILLER,"director1"),
                new Movie(3,"There's Something About Mary",119,Genre.COMEDY,"director2"),
                new Movie(4,"Super 8",112,Genre.THRILLER,"director1"),
                new Movie(5,"Scream",111,Genre.HORROR,"director2"),
                new Movie(6,"Home Alone",103,Genre.COMEDY,"director1"),
                new Movie(7,"Matrix",136,Genre.ACTION,"director2"),
                new Movie(8,"Superman",140,Genre.ACTION,"director2")
        ));
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre_then_return_3_6() {
        Collection<Movie> moviesByGenre = movieService.findMoviesByGenre(Genre.COMEDY);
        List<Integer> collect = moviesByGenre.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(collect, CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_duration_then_return_2_3_4_5_6() {
        Collection<Movie> moviesByGenre = movieService.findMoviesByLenght(120);
        List<Integer> collect = moviesByGenre.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(collect, CoreMatchers.is(Arrays.asList(2,3,4,5,6)));
    }

    @Test
    public void return_movies_by_name_then_return_4_8(){
        Collection<Movie> moviesByName = movieService.findMoviesByName("super");
        List<Integer> collect = moviesByName.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(collect, CoreMatchers.is(Arrays.asList(4,8)));
    }

    @Test
    public void return_movies_by_director_then_return_1_3_5_7_8(){
        Collection<Movie> moviesByName = movieService.findMoviesByDirector("Director2");
        List<Integer> collect = moviesByName.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(collect, CoreMatchers.is(Arrays.asList(1,3,5,7,8)));
    }

    @Test
    public void given_template_with_id_and_all_other_params_it_will_return_only_the_id_movie(){
        Movie movie = new Movie(4, "Memento", 123, Genre.THRILLER, "director1");
        Collection <Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        List<Integer> collect = moviesByTemplate.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(collect,CoreMatchers.is(Arrays.asList(4)));
    }

    @Test
    public void given_template_without_id_and_with_director_name_params_it_will_return_movies_2_4_6(){
        Movie movie = new Movie(null, null, null, null, "director1");
        Collection <Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        List<Integer> collect = moviesByTemplate.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(collect,CoreMatchers.is(Arrays.asList(2,4,6)));
    }

    @Test
    public void given_template_with_duration_and_genre_ACTION_then_return_movies_7_8(){
        Movie movie = new Movie(null, null, 140, Genre.ACTION, null);
        Collection <Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        List<Integer> collect = moviesByTemplate.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(collect,CoreMatchers.is(Arrays.asList(7,8)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_template_with_negative_duration_it_will_throw_and_IllegalArgumentException(){
        Movie movie = new Movie(null, null, -120, Genre.ACTION, null);
        Collection <Movie> moviesByTemplate = movieService.findMoviesByTemplate(movie);
        List<Integer> collect = moviesByTemplate.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(collect,CoreMatchers.is(Arrays.asList(7,8)));
    }
}