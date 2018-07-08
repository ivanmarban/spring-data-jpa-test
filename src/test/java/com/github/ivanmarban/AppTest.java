package com.github.ivanmarban;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.ivanmarban.AppConfig;
import com.github.ivanmarban.Movie;
import com.github.ivanmarban.MovieRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AppTest {

    @Autowired
    private MovieRepository repository;

    @Test
    public void searchMovies() throws AssertionError {

	List<Movie> movies = repository.search("Odyssey");

	assertEquals("Movies should be 0", 0, movies.size());

	Movie movie = new Movie();

	movie.setId(new Integer(1));
	movie.setTitle("2001: A Space Odyssey");
	movie.setYear("1968");
	movie.setRated("G");
	movie.setRuntime("160 min");
	movie.setGenre("Mystery, Sci-Fi");
	movie.setDirector("Stanley Kubrick");

	repository.save(movie);

	movies = repository.search("Odyssey");

	assertEquals("Movie should be: 2001: A Space Odyssey", "2001: A Space Odyssey", movies.get(0).getTitle());

    }

}
