package org.example.test.movies.data;

import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryJdbcIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
         movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies(){
        Collection<Movie> movies = movieRepositoryJdbc.findAll();
        assertThat(movies,is(Arrays.asList(
                new Movie(1,"Dark Knight",152, Genre.ACTION,"director1"),
                new Movie(2,"Memento",113, Genre.THRILLER,"director2"),
                new Movie(3,"Matrix",136, Genre.ACTION,"director1")
        )));
    }

    @Test
    public void load_movie_by_id(){
        Movie movie = movieRepositoryJdbc.findById(2);
        assertThat(movie,is(new Movie(2,"Memento",113,Genre.THRILLER,"director2")));
    }

    @Test
    public void insert_movie(){
        Movie newMovie = new Movie("Super 8", 112, Genre.THRILLER,"director2");
        movieRepositoryJdbc.saveOrUpdate(newMovie);
        Movie loadedMovie = movieRepositoryJdbc.findById(4);
        assertThat(loadedMovie,is(new Movie(4,"Super 8", 112, Genre.THRILLER,"director2")));
    }

    @After
    public void tearDown() throws Exception {
        final Statement statement = dataSource.getConnection().createStatement();
        statement.execute("drop all objects delete files");
    }
}