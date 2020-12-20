package org.example.test.movies.data;

import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object [] args = {id};
        return jdbcTemplate.queryForObject("select * from movie where id = ?",args,this::mapResultSet);
    }

    @Override
    public Collection<Movie> findAll() {
        RowMapper <Movie> movieMapper = this::mapResultSet;
        return jdbcTemplate.query("select * from movie",movieMapper);
    }

    public Movie mapResultSet(ResultSet rs,int i) throws SQLException {
        return new Movie(rs.getInt("id"),rs.getString("name"),rs.getInt("minutes"), Genre.valueOf(rs.getString("genre")),rs.getString("director"));
    }



    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movie (name,minutes,genre,director) values (?,?,?,?)",movie.getName(),movie.getMinutes(),movie.getGenre().toString(),movie.getDirector());
    }
}
